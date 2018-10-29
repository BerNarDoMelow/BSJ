package business;

import dataaccess.PersistenceException;
import dataaccess.VendedorRowDataGateway;

import java.sql.SQLException;

public class VendedorTransactionsScripts {

    public static void newVendedor(int numero_func, String nome, int telefone) throws PersistenceException, ApplicationException {
        try{
            VendedorRowDataGateway vendedor = new VendedorRowDataGateway(numero_func, String nome,telefone);
            vendedor.insert();
        }catch(SQLException e){
            throw new ApplicationException("erro: " + e.getErrorCode());
        }
    }
}
