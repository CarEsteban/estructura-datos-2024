public class HashOrganica implements IHash{
    /**
     * Método que genera un hash orgánico de un valor
     * @param value
     * @return hash
     */
    @Override
    public String generateHash(String value) {
        int hash = 0;
        for (int i = 0; i < value.length(); i++) {
            hash = (hash * 31) + value.charAt(i);
        }
        return Integer.toString(hash);
    }
    
}