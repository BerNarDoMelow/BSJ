package business;

import dataaccess.PersistenceException;
import dataaccess.VendedorRowDataGateway;

import java.sql.SQLException;

public class VendedorTransactionsScripts {

    public static void newVendedor(int numero_func, String nome, int telefone) throws ApplicationException {
        try{
            VendedorRowDataGateway vendedor = new VendedorRowDataGateway(numero_func,nome,telefone);
            vendedor.insert();
        }catch(PersistenceException e){
            throw new ApplicationException("Erro");
        }
    }
}
