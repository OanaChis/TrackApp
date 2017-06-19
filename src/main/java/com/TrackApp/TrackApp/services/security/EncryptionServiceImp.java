package com.TrackApp.TrackApp.services.security;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.stereotype.Service;

/**
 * Created by oana_ on 6/15/2017.
 */
@Service
public class EncryptionServiceImp  implements EncryptionService{

    private StrongPasswordEncryptor strongEncryptor;

    public void setStrongEncryptor(StrongPasswordEncryptor strongEncryptor) {
        this.strongEncryptor = strongEncryptor;
    }

    @Override
    public void setStrongPasswordEncryptor(StrongPasswordEncryptor strongEncryptor) {
        this.strongEncryptor = strongEncryptor;

    }

    @Override
    public String encryptString(String input) {
        return  strongEncryptor.encryptPassword(input);
    }

    @Override
    public boolean checkPassword(String plainPassword, String encryptedPassword) {
        return strongEncryptor.checkPassword(plainPassword,encryptedPassword);
    }


}
