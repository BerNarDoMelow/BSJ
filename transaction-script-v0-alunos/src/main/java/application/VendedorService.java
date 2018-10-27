package application;

import business.VendedorToSaleTransactionsScripts;

public class VendedorService {

    ///Variaveis -> Numero de Scripts
    private VendedorToSaleTransactionsScripts vendedortosaleTS;

    public VendedorService(){
        vendedortosaleTS = new VendedorToSaleTransactionsScripts();
    }

    public void vendedorToSale(int sale_id,int vendedor_id){
        vendedortosaleTS.vendedorToSale(sale_id,vendedor_id);
    }

    public void comissaoToVenda(){

    }

    public void updateComissao(int comissao_id){

    }

    public void anularComissao(){

    }

}