package com.TrackApp.TrackApp.services.security;

import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 * Created by oana_ on 6/15/2017.
 */
public interface EncryptionService {

    String encryptString(String input);
    boolean checkPassword(String plainPassword, String encryptedPassword);
    void setStrongPasswordEncryptor(StrongPasswordEncryptor strongEncryptor);

}
