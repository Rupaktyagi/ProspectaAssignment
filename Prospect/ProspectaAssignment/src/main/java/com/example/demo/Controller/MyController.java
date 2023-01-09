package com.example.demo.Controller;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Exception.IlligalIInputEception;
import com.example.demo.model.Data;
import com.example.demo.model.Entry;
import com.example.demo.model.ResponseDTO;



@Controller
public class MyController {

	@Autowired
	private RestTemplate restTempltae;
	
	
	@GetMapping("/entries/{category}")
	public ResponseEntity<List<ResponseDTO>> getentriesHandler(@PathVariable("category") String category) throws IlligalIInputEception
	{
		
        Data d=restTempltae.getForObject("https://api.publicapis.org/entries", Data.class);
		List<Entry> elist=d.getEntries();

		List<ResponseDTO> rlist=new ArrayList<>();
		boolean check=false;
		for(Entry e:elist)
		{
			String s=e.getCategory();
			String[] str=s.split(" & ");
			
				if(str[0].equals(category))
				{
					check=true;
					rlist.add(new ResponseDTO(e.getApi(), e.getDescription()));
				}	
				
		}
		if(check==false)
		{
			throw new IlligalIInputEception("There is no category with this name "+category);
		}
		
		return new ResponseEntity<List<ResponseDTO>>(rlist,HttpStatus.OK);
		
	}
	
	
	@PostMapping("/entries")
	public ResponseEntity<String> saveEntiesHandler(@RequestBody Entry entr)
	{
		
		Data d=restTempltae.getForObject("https://api.publicapis.org/entries", Data.class);
		
		List<Entry> entries=d.getEntries();
		d.setCount(d.getCount()+1);
		entries.add(entr);
	
		
		return new  ResponseEntity<String>("Entry save successfully",HttpStatus.ACCEPTED);
		
		
	}
	
	
	
	
	
	
	
}
