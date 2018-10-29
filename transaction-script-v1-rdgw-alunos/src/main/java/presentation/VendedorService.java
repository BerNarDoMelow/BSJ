package presentation;

import business.ApplicationException;
import business.VendedorToSaleTransactionsScripts;
import business.ComissaoToSaleTransactionsScripts;
import business.VendedorTransactionsScripts
import dataaccess.PersistenceException;

public class VendedorService {

    ///Variaveis -> Numero de Scripts
    private VendedorToSaleTransactionsScripts vendedortosaleTS;
    private ComissaoToSaleTransactionsScripts comissaotosaleTS;
    private VendedorTransactionsScripts vendedorTS;

    public VendedorService(){
        vendedortosaleTS = new VendedorToSaleTransactionsScripts();
        comissaotosaleTS = new ComissaoToSaleTransactionsScripts();
        vendedorTS = new VendedorTransactionsScripts();
    }


    public void newVendedor(int numero_func, String nome, int telefone){
        vendedorTS.newVendedor(numero_func,nome,telefone);
    }

    public void vendedorToSale(int sale_id,int vendedor_id) throws PersistenceException, ApplicationException {
        vendedortosaleTS.vendedorToSale(sale_id,vendedor_id);
    }

    /**
     * ACHO QUE PODE ESTAR NO SALESERVICE
     */
    public void comissaoToSale(){
        comissaotosaleTS.comissaoToSale(int sale_id, int comissao);
    }

    public void updateComissao(int comissao_id){

    }

    public void anularComissao(){

    }

}