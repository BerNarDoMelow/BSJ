package dataaccess;

import business.ApplicationException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendedorRowDataGateway {

    private static int numero;
    private static String nome;
    private static int telefone;
    private static int id;
    private static double comissao;

    private static final String INSERT_VENDEDOR = "insert into vendedor (numero,nome,telefone,totalcomissao) values (?,?,?,?)";

    public VendedorRowDataGateway(int numero, String nome, int telefone){
        this.numero = numero;
        this.nome = nome;
        this.telefone = telefone;
        this.comissao = 0.0;
    }

    public static int getId(){
        return id;
    }

    public static int getNumero(){
        return numero;
    }

    public static double getComissao() {
        return comissao;
    }

    public static int getTelefone() {
        return telefone;
    }

    public void insert() throws PersistenceException, ApplicationException{
        try(PreparedStatement statement = DataSource.INSTANCE.prepareGetGenKey(INSERT_VENDEDOR)){
            statement.setInt(1,numero);
            statement.setString(2,nome);
            statement.setInt(3,telefone);
            statement.setDouble(4,comissao);
            statement.executeUpdate();
            try(ResultSet resultSet = statement.getGeneratedKeys()){
                resultSet.next();
                id = resultSet.getInt(1);
            }
        }catch (SQLException e){
            throw new ApplicationException("erro: " + e.getErrorCode());
        }
    }

    private static final String SQLCommandUpdateComissao = "update vendedor v set v.comissao = ? where v.id = ?";

    public static void updateComissao(int vendedorId,double Comissao) throws PersistenceException{
        try(PreparedStatement statement = DataSource.INSTANCE.prepareGetGenKey(SQLCommandUpdateComissao)){
            statement.setDouble(1,comissao);
            statement.setInt(2,vendedorId);
            statement.executeUpdate();
            comissao = Comissao;
        }catch (SQLException e) {
            throw new PersistenceException("Internal error!", e);
        }
    }

    private static final String SQLGetVendedor = "select * from vendedor v where v.id = ?";

    public static VendedorRowDataGateway getVendedorById(int vendedorId) throws PersistenceException{
        try(PreparedStatement sta = DataSource.INSTANCE.prepare(SQLGetVendedor)){
            sta.setInt(1,vendedorId);
            try(ResultSet resultSet = sta.executeQuery()){
                return find(resultSet);
            }
        }catch (SQLException e){
            throw new PersistenceException("Nao existe tal coisa");
        }
    }


    public static VendedorRowDataGateway find(ResultSet rs) throws PersistenceException{
        try{
            rs.next();
            VendedorRowDataGateway vs = new VendedorRowDataGateway(rs.getInt("numero"),rs.getString("nome"), rs.getInt("telefone"));
            vs.id = rs.getInt("id");
            vs.comissao = rs.getDouble("comissao");
            return vs;
        }catch (SQLException e){
            throw new PersistenceException("Cafla");
        }
    }

    private static final String SQLGetVendedorByFuncNumber = "select * from vendedor v where v.numero = ?";

    public static VendedorRowDataGateway findByFuncionarioNumb(int funcNumber) throws PersistenceException{
        try(PreparedStatement sta = DataSource.INSTANCE.prepare(SQLGetVendedorByFuncNumber)){
            sta.setInt(1,funcNumber);
            try(ResultSet resultSet = sta.executeQuery()){
                return find(resultSet);
            }
        }catch (SQLException e){
            throw new PersistenceException("Nao existe tal coisa");
        }
    }
}
