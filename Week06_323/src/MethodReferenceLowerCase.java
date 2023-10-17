import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceLowerCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> listOfNames=Arrays.asList(new String[]{"Apple", "Banana", "Cherry"});
		
		 List<String> lowerCaseList = listOfNames.stream()
		            .map(String::toLowerCase)
		            .collect(Collectors.toList());
		 
		 System.out.println(lowerCaseList);
	}

}