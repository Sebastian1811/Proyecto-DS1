/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eljho
 */
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
public class BD {
    private String url;
    private String user;
    private String password;
    private Connection conex;
    private Statement st;
    private ResultSet rs;
    private String query;
    private boolean grantAccess = false;
    boolean existeCorreo=false;
    Vector <String> ValoresColumna ;
    
    void BD(){
       
    };
    
    void ConectarBd(){
         url = "jdbc:postgresql://localhost:5432/GestionReservas";
         user = "reservx";
         password = "reservx1234";
         try {
             Class.forName("org.postgresql.Driver");
             conex = DriverManager.getConnection(url,user,password);
             System.out.println("Se ha conectado exitosamente a la base de datos");
         } catch(Exception exc) {
             System.out.println("Error: "+ exc.getMessage());
         }
    }
    
    void FinConexionBd(){
        try{
            conex.close();
            System.out.println("Ha finalizado la conexion con la base de datos");
        }catch(Exception e){
            System.out.println("Errorx: "+ e.getMessage());
        }
    }
    
    void setStatement(){
        try{
            st = conex.createStatement();
        }catch(Exception e){
            System.out.println("Errorx: "+ e.getMessage());
        }   
    }
    
    void validarUser(String user,String pass){
        ConectarBd();
        setStatement();
        String id;
        String passrd;
        try{
            rs = st.executeQuery("select correo,contraseña from users where (correo = '" + user + "' and contraseña = '" + pass + "')");
            if(rs.next()){
                rs.close();
                st.close();
                setGrantAccess(true);
            }else{
                rs.close();
                st.close();
                setGrantAccess(false);
                FinConexionBd();
            } 
        }catch(Exception e){
             System.out.println("Errorx: "+ e.getMessage()); 
        }
    }
    
    void validarCorreo(String correo){
        ConectarBd();
        setStatement();
        String id;
        String passrd;
        try{
            rs= st.executeQuery("select correo from users where (correo = '"+correo+"'"+")");
            if(rs.next()){
                rs.close();
                st.close();
                existeCorreo = true;
            }else{
                rs.close();
                st.close();
                existeCorreo = false;
                FinConexionBd();
            } 
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "Errorx: "+e.getMessage(), "InfoBox" , JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    String Exquery(String query){
        String Resultado ="";
        this.query = query;
        setStatement();
        try{
            rs = st.executeQuery(query);
            while(rs.next()){
                for(int i = 1; i<=rs.getMetaData().getColumnCount();i++){
                    Resultado += rs.getString(i)+" | ";
                }
                Resultado += "\n";
            }
            st.close();
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "Errorx: "+e.getMessage(), "InfoBox" , JOptionPane.INFORMATION_MESSAGE);
        }
        return Resultado;
    }
    
    String QueryGetData(String user,String datum){ // obtener todos los datos de un usuario
        String role="";
        setStatement();
       try{
           query = "select "+ datum +" from users u inner join roles r on u.documento = r.documento where(u.correo = '"+user+"')" ;
           rs= st.executeQuery(query);
           if(rs.next()){
               if(datum.equals("u.documento")){
                   role= rs.getString(1);
               }else{
                   role = rs.getString(datum);
               }
           }else{
               System.out.println("nada");
           }
           rs.close();
           st.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Errorx: "+e.getMessage(), "InfoBox" , JOptionPane.INFORMATION_MESSAGE);
        }
       return role;
    }
    
    void QueryInsert(String Values, String Table){ // Inserto una tupla a una tabla, solo se pueden cargar todos los valores a la tupla al tiempo
       query = "insert into " + Table + " values ("+Values+");";   
        setStatement();
        try{
            st.executeUpdate(query);
            st.close();
        }catch(Exception e){
            System.out.println("Errorx: "+ e.getMessage()); 
           JOptionPane.showMessageDialog(null, "Errorx: "+e.getMessage(), "InfoBox" , JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    void QueryInsertColumnas(String Values, String Table,String columnas){ // Inserto una tupla a una tabla, solo se pueden cargar todos los valores a la tupla al tiempo
        query = "insert into "+ Table+"("+columnas+ ")" +  " values ("+Values+")";
         System.out.println(""+query);
        setStatement();
        try{
            st.executeUpdate(query);
            st.close();
        }catch(Exception e){
            System.out.println("Errorx: "+ e.getMessage()); 
           JOptionPane.showMessageDialog(null, "Errorx: "+e.getMessage(), "InfoBox" , JOptionPane.INFORMATION_MESSAGE);
        }   
    }
    
    void QueryInsertColumnaswhere(String Values, String Table,String columnas,String Ccomparada,String valueCompa){ // Inserto una tupla a una tabla, solo se pueden cargar todos los valores a la tupla al tiempo
        query = "insert into "+ Table+"("+columnas+ ")" +  " values ("+Values+") where("+Ccomparada+"="+valueCompa+")";
         System.out.println(""+query);
        setStatement();
        try{
            st.executeUpdate(query);
            st.close();
        }catch(Exception e){
            System.out.println("Errorx: "+ e.getMessage()); 
           JOptionPane.showMessageDialog(null, "Errorx: "+e.getMessage(), "InfoBox" , JOptionPane.INFORMATION_MESSAGE);
        }   
    }
     
    void queryUpdate(String atributo, String newValue,String tabla,String columnaCondicion,String valorColumnacondicion){
         ConectarBd();
         query = "Update "+tabla+" set "+ atributo + " = '"+ newValue+"' where ("+ columnaCondicion+ " = '"+valorColumnacondicion+"')";
         setStatement();
         
         try{
            st.executeUpdate(query);
            st.close();
           
        }catch(Exception e){
            System.out.println("Errorx: "+ e.getMessage()); 
           JOptionPane.showMessageDialog(null, "Errorx: "+e.getMessage(), "InfoBox" , JOptionPane.INFORMATION_MESSAGE);
        }   
          //FinConexionBd();
     }
    void queryDelete(String Query){
        
         query = Query;
         try{
           PreparedStatement St = conex.prepareStatement(Query);
           int x = St.executeUpdate();
           St.close();
        }catch(Exception e){
            System.out.println("Errorx: "+ e.getMessage()); 
           JOptionPane.showMessageDialog(null, "Errorx: "+e.getMessage(), "InfoBox" , JOptionPane.INFORMATION_MESSAGE);
        }   
       
     }
     
    String getAllusers(String tabla,String tabla2){
         String resultado ="";
         query = "select * from " + tabla + " t1 inner join " + tabla2 + " t2 on t1.documento = t2.documento";
         setStatement();
         try{
            rs = st.executeQuery(query);
            while (rs.next()){
                resultado += rs.getString("documento") + " | " + 
                        rs.getString("nombre") + " | " + 
                        rs.getString("apellido") + " | " + 
                        rs.getString("correo") + " | " + 
                        rs.getString("_role") + "\n";
            }
            st.close();
           
        }catch(Exception e){
            System.out.println("Errorx: "+ e.getMessage()); 
           JOptionPane.showMessageDialog(null, "Errorx: "+e.getMessage(), "InfoBox" , JOptionPane.INFORMATION_MESSAGE);
        }  
         return resultado;
     }
    
    public String getAllfromTable(String tabla){
        setStatement();
        String Resultado="";
        query = "select * from " + tabla;
        try{
            rs = st.executeQuery(query);
            while(rs.next()){
                for(int i = 1; i<=rs.getMetaData().getColumnCount(); i++){
                    Resultado += rs.getString(i) + " ";
                }
                Resultado += "\n";
            }
            st.close();
        }catch (Exception e){
            System.out.println("Errorx: " + e.getMessage()); 
            JOptionPane.showMessageDialog(null, "Errorx: " + e.getMessage(), "InfoBox", JOptionPane.INFORMATION_MESSAGE);
        }
        return Resultado;
    }
    
    public String getAllofTablasJoinned(String tabla1,String tabla2,String Columnas,String Keyp1,String Keyp2){
        setStatement();
        String resultado = "";
        query = "select "+ Columnas +" from "+tabla1+" inner join "+tabla2+" on "+tabla1+"."+Keyp1+" = "+tabla2+"."+Keyp2;
        System.out.println(query);
        try{
            rs = st.executeQuery(query);
            while(rs.next()){
                for(int i = 1; i<=rs.getMetaData().getColumnCount();i++){
                    resultado += rs.getString(i)+"           ";
                }
                resultado += "\n";
            }
            st.close();
        }catch(Exception e){
            System.out.println("Errorx: "+ e.getMessage()); 
            JOptionPane.showMessageDialog(null, "Errorx: "+e.getMessage(), "InfoBox" , JOptionPane.INFORMATION_MESSAGE);
        }
        return resultado;
    }
        public String getAllofTablasJoinnedWhere(String tabla1,String tabla2,String Columnas,String Keyp1,String Keyp2,String Ccomparada,String valorComparacio){
        setStatement();
        String resultado = "";
        query = "select "+ Columnas +" from "+tabla1+" inner join "+tabla2+" on "+tabla1+"."+Keyp1+" = "+tabla2+"."+Keyp2+" where ("+Ccomparada+" = "+valorComparacio+")";    
        try{
            rs = st.executeQuery(query);
            while(rs.next()){
                for(int i = 1; i<=rs.getMetaData().getColumnCount();i++){
                    resultado += rs.getString(i)+"           ";
                }
                resultado += "\n";
            }
            st.close();
        }catch(Exception e){
            System.out.println("Errorx: "+ e.getMessage()); 
            JOptionPane.showMessageDialog(null, "Errorx: "+e.getMessage(), "InfoBox" , JOptionPane.INFORMATION_MESSAGE);
        }
        return resultado;
    }
    
    public Vector<String> getColumnValues(String Columna,String tabla){
         setStatement();
         ValoresColumna = new Vector <String> ();
         query = "select "+Columna+ " from "+tabla;
         try{
             rs = st.executeQuery(query);
             while(rs.next()){
                 ValoresColumna.add(rs.getString(Columna));
             }
             st.close();
         }catch(Exception e){
            System.out.println("Errorx: "+ e.getMessage()); 
            JOptionPane.showMessageDialog(null, "Errorx: "+e.getMessage(), "InfoBox" , JOptionPane.INFORMATION_MESSAGE);
         }
      return ValoresColumna;
    }
    
    public Vector<String> getColumnValuesWhere(String Columna, String tabla, String Ccomparada, String valueComparacion){
        setStatement();
        ValoresColumna = new Vector <String> ();
        query = "select " + Columna + " from " + tabla + " where( " + Ccomparada + " = " + valueComparacion + " )";
        try{
            rs = st.executeQuery(query);
            while(rs.next()){
                ValoresColumna.add(rs.getString(Columna));
            }
            st.close();
        }catch(Exception e){
           System.out.println("Errorx: "+ e.getMessage()); 
           JOptionPane.showMessageDialog(null, "Errorx: "+e.getMessage(), "InfoBox" , JOptionPane.INFORMATION_MESSAGE);
        }
        return ValoresColumna;
    }
    
    public String getRowofTablasJoinned(String tabla1,String tabla2,String Keyp1,String Keyp2,String ColumnaComparada,String ValorComparacion){
        setStatement();
        String resultado = "";
        query = "select * from "+tabla1+" inner join "+tabla2+" on "+tabla1+"."+Keyp1+" = "+tabla2+"."+Keyp2+" where("+ColumnaComparada+" = "+ValorComparacion+")";
        System.out.println(query);
        try{
            rs = st.executeQuery(query);
            if(rs.next()){
                for(int i = 1; i<=rs.getMetaData().getColumnCount();i++){
                    resultado += rs.getString(i)+"\n";
                }
            }
            st.close();
        }catch(Exception e){
            System.out.println("Errorx: "+ e.getMessage()); 
            JOptionPane.showMessageDialog(null, "Errorx: "+e.getMessage(), "InfoBox" , JOptionPane.INFORMATION_MESSAGE);
        }
        return resultado;
    }
    
    public String getRowofTable(String Table,String valorComparado,String comparacion){
        setStatement();
        String Resultado = "";
        query = "Select * from "+Table+" where( "+valorComparado+" = "+comparacion+")";
        try{
            rs = st.executeQuery(query);
            if(rs.next()){
                for(int i = 1; i<=rs.getMetaData().getColumnCount();i++){
                    Resultado += rs.getString(i)+"\n";
                }
            }
            st.close();
        }catch (Exception e){
            System.out.println("Errorx: "+ e.getMessage()); 
            JOptionPane.showMessageDialog(null, "Errorx: "+e.getMessage(), "InfoBox" , JOptionPane.INFORMATION_MESSAGE);
        }
        return Resultado;
    }
    /**
     * @return the grantAccess
     */
    public boolean isGrantAccess() {
        return grantAccess;
    }

    /**
     * @param grantAccess the grantAccess to set
     */
    public void setGrantAccess(boolean grantAccess) {
        this.grantAccess = grantAccess;
    }
}
   
    

