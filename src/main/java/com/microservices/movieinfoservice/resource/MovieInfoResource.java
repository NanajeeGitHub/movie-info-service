package com.microservices.movieinfoservice.resource;

import com.microservices.movieinfoservice.models.Movie;
import com.microservices.movieinfoservice.models.MovieSummary;
//import org.graalvm.compiler.nodeinfo.StructuralInput;
import com.microservices.movieinfoservice.models.ServerTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {

    @Value("${api.key}")
    private String apiKey;

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId){

        System.out.println("apiKey----->"+apiKey+" movieId:"+movieId);
        RestTemplate restTemplate=new RestTemplate();
        MovieSummary movieSummary=restTemplate.getForObject("https://api.themoviedb.org/3/movie/"+movieId+"?api_key="+apiKey,MovieSummary.class);
        return  new Movie(movieId,movieSummary.getOriginal_title(),movieSummary.getOverview());
    }

    @RequestMapping("/testBinance")
    public void testBinance(){
        System.out.println("-------------testBinance------>");
        RestTemplate restTemplate=new RestTemplate();
        //ServerTime serverTime=restTemplate.getForObject("https://api.binance.com/api/v1/ping"+"?api_key="+apiKey, ServerTime.class);
        ServerTime serverTime=restTemplate.getForObject("https://api.binance.com/api/v1/time",ServerTime.class);

        System.out.println("-------serverTime--->"+serverTime);
        //return  new Movie(movieId,movieSummary.getOriginal_title(),movieSummary.getOverview());
    }
}
