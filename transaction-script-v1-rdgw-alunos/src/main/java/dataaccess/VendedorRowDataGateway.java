package dataaccess;

import business.ApplicationException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendedorRowDataGateway {

    private int numero;
    private String nome;
    private int telefone;
    private int id;

    private static final String INSERT_VENDEDOR = "insert into vendedor (numero,nome,telefone) values (?,?,?)";

    public VendedorRowDataGateway(int numero, String nome, int telefone){
        this.numero = numero;
        this.nome = nome;
        this.telefone = telefone;
    }

    public int getId(){
        return id;
    }

    public int getNumero(){
        return numero;
    }

    public void insert() throws PersistenceException, ApplicationException{
        try(PreparedStatement statement = DataSource.INSTANCE.prepareGetGenKey(INSERT_VENDEDOR)){
            statement.setInt(1,numero);
            statement.setString(2,nome);
            statement.setInt(3,telefone);
            statement.executeUpdate();
            try(ResultSet resultSet = statement.getGeneratedKeys()){
                resultSet.next();
                id = resultSet.getInt(1);
            }
        }catch (SQLException e){
            throw new ApplicationException("erro: " + e.getErrorCode());
        }
    }
}
