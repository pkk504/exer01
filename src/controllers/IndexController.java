package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.google.gson.Gson;

import models.MovieDao;

@Controller
@RequestMapping("/ticket")
public class IndexController {
	@Autowired
	MovieDao movieDao;
	Map map=new HashMap();
	
	@GetMapping("/index.do")
	public  String indexHandle(WebRequest wr,ModelMap modelmap) {
		System.out.println("indexController.indexHandle()");
		if(wr.getAttribute("auth",wr.SCOPE_SESSION)==null) {
			return "redirect:auth.do";
			}else { 
				/*String[] movies= "괴물,상류사회,서치,인피니티워".split(",");
				modelmap.put("movies", movies);*/
				List<String> lii=movieDao.litwotitle();
				modelmap.put("movies", lii);
			return "/index";
		}
		
		
	}
	
	
	@PostMapping(path="/zzz.do",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String movietime(@RequestBody(required=false) String body) {
		List<Map> ss=movieDao.litwo(body);
		System.out.println(ss);
		System.out.println(body);
		
		Gson gson= new Gson();
		
			String t1=gson.toJson(ss);
			System.out.println(t1);
			/*System.out.println(ss.get("TIMES"));*/
			/*for(int i=0; i<ss.size();i++) {
				System.out.println(ss.get(i));
			}*/
			
			
			
			System.out.println(ss);
			
			
			/*List<Map> ss=movieDao.lione(body);
			System.out.println(ss);
			String t1=gson.toJson(ss);
			System.out.println(t1);
			System.out.println(ss.get("TIMES"));
			for(int i=0; i<ss.size();i++) {
				System.out.println(ss.get(i));
			}
			
			System.out.println("야호랑이"+"["+t1+"]");
			
			System.out.println(ss);
		
		*/
			
		/*	MovieDao mdao=new MovieDao();
			String aa=wr.getParameter("moviemomo");
			System.out.println(aa);*/
			
			/*System.out.println("line="+line);
			Map map =gson.fromJson(line, Map.class);
			System.out.println("map.get=" + (String)map.get("moviemomo"));
			List<Integer> ss=mdao.getShowtimes((String)map.get("moviemomo"));
			
			String qqq=gson.toJson("상영:"+ss);
			System.out.println(qqq);
			wr.setAttribute("movietime",ss , wr.SCOPE_SESSION);
			*/
			
			return t1;
		
		
		
		
	}
	
	
/*	@GetMapping
	@RequestMapping("/auht.do")
	public String authHanlde(WebRequest wr) {
		return "/WEB-INF/views/auth.jsp";
		
	}*/
	
	@GetMapping("/auth.do")
	public String authgetHandler() {
		return "/auth";
		
		
	}
	
	
	
	@PostMapping("/auth.do")
	public String authpostHandler(WebRequest wr) {
		if(wr.getParameter("nick").length()<1||wr.getParameter("phon").length()<1) {
			return "/auth";
		}else {
		
		String name=wr.getParameter("nick");
		String phon=wr.getParameter("phon");
		wr.setAttribute("nick", name,WebRequest.SCOPE_SESSION);
		wr.setAttribute("phon", phon,WebRequest.SCOPE_SESSION);
		wr.setAttribute("auth", "zz",WebRequest.SCOPE_SESSION);
		return "redirect:index.do";
		}
		
		
		
	}
	
	@GetMapping("/seat.do")
	public String seatHandle(WebRequest wr) {
		if(wr.getParameter("movie").length()<1||wr.getParameter("time").length()<1||wr.getParameter("num").length()<1) {
			return "redirect:index.do";
		}else {
		Map map =new HashMap<>();
		
		String movie=wr.getParameter("movie");
		String num=wr.getParameter("num");
		int time=Integer.parseInt(wr.getParameter("time"));
		wr.setAttribute("movie", movie,WebRequest.SCOPE_SESSION);
		wr.setAttribute("time", time,WebRequest.SCOPE_SESSION);
		wr.setAttribute("num", num,WebRequest.SCOPE_SESSION);
		System.out.println(movie);
		System.out.println(time);
		System.out.println(num);
		
		map.put("title", movie);
		map.put("time", time);
		int n= movieDao.litwono(map);
		List<String> lii=movieDao.getmovieseat(n);
		wr.setAttribute("setseater", lii, wr.SCOPE_SESSION);
		for(int i=0; i<lii.size();i++) {
			System.out.println(lii.get(i));
		}
		return "/seat";
		}
	}
	@GetMapping("/order.do")
	
	
		public String orderHandler(WebRequest wr) {
		Gson gson =new Gson();
			System.out.println(Integer.parseInt(wr.getAttribute("num", wr.SCOPE_SESSION).toString()));
	/*		System.out.println("호로록"+wr.getParameterValues("seater").length);*/
			System.out.println(Integer.parseInt(wr.getAttribute("num", wr.SCOPE_SESSION).toString()));
			if(wr.getParameterValues("seater")==null) {
				System.out.println(wr.getParameterValues("seater"));
				return "/seat";
			}else {
			
			/*if(wr.getParameterValues("seater").length<Integer.parseInt(wr.getAttribute("num", wr.SCOPE_SESSION).toString())) {
				return "/seat";
			}*/
			}
			
			String[] seat=wr.getParameterValues("seater");
			List la =new ArrayList<>();
			String seater="";
			for(int i=0;i<seat.length;i++) {
				System.out.println(seat[i]);
				la.add(seat[i]);
			}
			System.out.println(seat.toString());
			String ssss=la.toString();
			System.out.println("커ㅗㄹ록+"+seat);
			System.out.println("시터 = "+seater);
			String seaterr =gson.toJson(la);
			Map map =new HashMap<>();
			map.put("title", wr.getAttribute("movie", wr.SCOPE_SESSION));
			map.put("time",(int) wr.getAttribute("time", wr.SCOPE_SESSION));
			wr.setAttribute("seat", seat,WebRequest.SCOPE_SESSION);
			Map mapin=new HashMap();
			int r=movieDao.litwono(map);
			System.out.println("넘버링 ="+r);
			mapin.put("r", r);
			mapin.put("nickname",wr.getAttribute("nick", wr.SCOPE_SESSION));
			mapin.put( "reservationtitle", wr.getAttribute("movie", wr.SCOPE_SESSION));
			mapin.put("reservationtime",(int)wr.getAttribute("time", wr.SCOPE_SESSION));
			
			mapin.put("seater", ssss);
			int n=movieDao.litwoin(mapin);
			System.out.println("처리결과 = "+n);
			if(n==1) {
			wr.setAttribute("pass", "passs", wr.SCOPE_REQUEST);
			return "/order";
			}else {
				return "/order";
			}
			
		}
	
	
	
	
	
	
	
	}
	
	
	
	
