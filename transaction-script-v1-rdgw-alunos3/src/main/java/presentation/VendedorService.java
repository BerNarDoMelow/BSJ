package presentation;

import business.ApplicationException;
import business.VendedorToSaleTransactionsScripts;
import business.ComissaoToSaleTransactionsScripts;
import business.VendedorTransactionsScripts;
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


    public void AddVendedor(int numero_func, String nome, int telefone) throws ApplicationException{
        vendedorTS.AddVendedor(numero_func,nome,telefone);
    }

    public void vendedorToSale(int sale_id,int funcNumb) throws PersistenceException, ApplicationException {
        vendedortosaleTS.vendedorToSale(sale_id,funcNumb);
    }

    /**
     * ACHO QUE PODE ESTAR NO SALESERVICE
     */
    public void comissaoToSale(int vendedor_id, double comissaoPercentagem) throws PersistenceException, ApplicationException{
        comissaotosaleTS.comissaoToSale(vendedor_id,comissaoPercentagem);
    }

    public void updateComissao(int comissao_id){

        return;
    }

    public void anularComissao(){
        return;
    }
}

/**
 try{
 VendedorRowDataGateway vrdgw = VendedorRowDataGateway.getVendedorById(vendedor_id);
 vrdgw.updateComissao(vendedor_id,comissao);
 }catch(PersistenceException e){
 throw new ApplicationException("Vendedor nao existe");
 }**/