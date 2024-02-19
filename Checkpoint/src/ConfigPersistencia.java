public class ConfigPersistencia {

    public static final int CSV_TYPE = 0;
    public static final int XML_TYPE = 1;
    public static final int JSON_TYPE = 2;

    public static IDataSource getInstance(int formatType){
       switch (formatType) {
        case CSV_TYPE:
            return new CSV();

        case XML_TYPE:
                
            return new XML();
        case JSON_TYPE:
                    
            return new JSON();
       
        default:
            return new CSV();
       } 
    }
}
