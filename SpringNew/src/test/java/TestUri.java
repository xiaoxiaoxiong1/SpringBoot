import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.logging.FileHandler;

import org.junit.Test;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class TestUri {
	@Test
	public void constructUriEncoded() {
	    UriComponents uriComponents = UriComponentsBuilder.newInstance()
	      .scheme("http").host("localhost").path("/junit5").build().encode();

	    assertEquals("http://localhost/junit5", uriComponents.toUriString());

	}

	@Test
	public void delefile(){
		File dir=new File("D:\\kankan");
		if(dir.isDirectory()){
			for (File dirjin:dir.listFiles()){
				if(dirjin.getName().indexOf("金艺")>-1){
					if(dirjin.list().length<=0){
						System.out.println("删除文件"+dirjin);
						dirjin.delete();
					}
				}
			}


		}
	}

/*	@Test
	public void toString() {
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
	}*/
}
