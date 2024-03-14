public class FactoryHash {
    IHash getInstanceHash(int index){
        switch(index){
            case 1:
                return new HashOrganica();
            case 2:
                return new HashMD5();
            case 3: 
                return new HashSHA_1();
            default:
                return null;
        }
    }
}
