package databaseobjects;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CardDAO implements DAO<Card> {

	Connection c = null;
	String databaseAddress = "Insert_Your_DB_Here";


	public CardDAO() {
		
		try {
			Class.forName("org.postgresql.Driver");
	        c = DriverManager
	        		.getConnection(databaseAddress);
	      } catch (Exception e) {
	    	  e.printStackTrace();
	    	  System.err.println(e.getClass().getName()+": "+e.getMessage());
	          System.exit(0);
	      }
	}

	private ResultSet createQuery(String query) {
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = c.createStatement();
		} 
		catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		} 
		finally {
			
		}
		
		try {
			rs = stmt.executeQuery(query);
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		  } 
		finally {

		}
		
		return rs;
		
	}

	private Card getCard(ResultSet rs) {
		
		String name = "";
		String className = "";
		int count = 0;
		
		try {
			rs.next();
			name = rs.getString("name");
			className = rs.getString("class");
			count = rs.getInt("count");
		} 
		catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		} 
		finally {

		}

		Card card = new Card(name, className, count);
		return card;
		
	}

	private List<Card> getCards(ResultSet rs) {
		
		List<Card> allCards = new ArrayList<Card>();
		String name = "";
		String className = "";
		int count = 0;

		try {
			
			while ( rs.next() ) {
				name = rs.getString("name");
				className = rs.getString("class");
				count = rs.getInt("count");
				Card card = new Card(name, className, count);
				allCards.add(card);
			}
			
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		} 
		finally {

		}
		
		return allCards;
		
	}

	@Override
	public Card getByName(String name) {
		
		String ourString = "select * from decklists where name = '" + name + "'";
		
		ResultSet rs = createQuery(ourString);
		Card card = getCard(rs);
		return card;
		
	}

	public Card getByName(String name, String tableName) {
		
		String ourString = "select * from " + tableName +" where name = '" + name + "'";
		
		ResultSet rs = createQuery(ourString);
		Card card = getCard(rs);
		return card;
		
	}

	@Override
	public List<Card> getByClass(String className) {
		
		List<Card> allCards = new ArrayList<Card>();
		
		ResultSet rs = createQuery("select * from decklists where class = '" + className + "'");
		allCards = getCards(rs);
		return allCards;

	}

	public List<Card> getByClass(String className, String tableName) {
		
		List<Card> allCards = new ArrayList<Card>();
		
		ResultSet rs = createQuery("select * from " + tableName + " where class = '" + className + "'");
		allCards = getCards(rs);
		return allCards;

	}

	@Override
	public List<Card> getAll() {
		
		List<Card> allCards = new ArrayList<Card>();
		
		ResultSet rs = createQuery("select * from decklists");
		allCards = getCards(rs);
		return allCards;

	}

	public List<Card> getAll(String tableName) {
		
		List<Card> allCards = new ArrayList<Card>();
		
		ResultSet rs = createQuery("select * from " + tableName);
		allCards = getCards(rs);
		return allCards;

	}
}
