package com.aspose.cloud.sdk.cells;
import java.lang.String;

public class Encryption
    {
        public Encryption()
        { 
        
        }

        private EncryptionType EncryptionType ;
        private String Password ;
        private int Keylength ;     
        
        public EncryptionType getEncryptionType(){return EncryptionType;}
        public String getPassword(){return Password;}
        public int getKeylength(){return Keylength;}      
        
        
        public void setEncryptionType(EncryptionType EncryptionType){ this.EncryptionType=EncryptionType;}
        public void setPassword(String Password){ this.Password=Password;}
        public void setKeylength(int Keylength){ this.Keylength=Keylength;}

    }