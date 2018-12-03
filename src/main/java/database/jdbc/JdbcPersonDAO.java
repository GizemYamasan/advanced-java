package database.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersonDAO implements PersonDAO{
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/demo";
	private static final String USER = "gizem";
	private static final String PASSWORD = "gizem";
	
	public JdbcPersonDAO() {
		try {
			Class.forName(DRIVER);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Person> findAll() {
		List<Person> people = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM demo.people")
		) {
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				people.add(new Person(rs.getInt(1), rs.getString(2)));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return people;
	}

	@Override
	public Person findById(Integer id) {
		Person p = null;
		
		try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM demo.people where id=?")
		 ){
			pst.setInt(1,id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				p = new Person(id,rs.getString("name"));
			}
			rs.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Integer save(Person p) {
		int generatedKey = 0;
		try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement pst = conn.prepareStatement("INSERT INTO demo.people (name) VALUES (?)",
															Statement.RETURN_GENERATED_KEYS)
		 ){
		pst.setString(1, p.getName());
		int uc  = pst.executeUpdate();
		if(uc != 1) throw new SQLException("No rows added");
		try(ResultSet keys = pst.getGeneratedKeys()){
			if(keys.next()){
				generatedKey = keys.getInt(1);
			}
		}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return generatedKey;
	}

	@Override
	public void delete(Person p) {
		try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement pst = conn.prepareStatement("DELETE FROM demo.people WHERE id=?",
															Statement.RETURN_GENERATED_KEYS)
		 ){
		pst.setInt(1, p.getId());
		int uc  = pst.executeUpdate();
		if(uc != 1) throw new SQLException("No rows remowed");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Integer> getIds() {
		List<Integer> ids = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement pst = conn.prepareStatement("SELECT id FROM demo.people")
		 ){
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				ids.add(rs.getInt(1));
			}
			rs.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ids;
	}


}
