package databaseobjects;
import java.util.List;

public interface DAO<T> {
	
    List<T> getAll();
    
    List<T> getByClass(String className);
    
    T getByName(String name);

}
