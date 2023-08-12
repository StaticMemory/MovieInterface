import Banner from "@/components/Banner";
import { useState } from "react";
import { useRouter } from "next/router";
import MovieSplashPage from "@/components/MovieSplashPage";
import Link from "next/link";
export default function Movie(props){
    const router = useRouter();
    const [searchOption, setSearchOption] = useState("");
    console.log(props.actorVal);
    return <>

    
    <Banner/>
    <div className="border-2 border-black justify-center flex bg-offgrayhighlight">
        <input className="text-black w-PreviewCardWidth border-2 border-offgrayhighlight" placeholder="  Search Movies, TV Shows, and Famous Actors!"
        onChange={(event) => {
            setSearchOption(event.target.value);
        }}
        onKeyDown={(event)=>{
            if(event.key === 'Enter'){
                router.push({pathname :"/Search",
                query : {
                    searchResult : searchOption
                }
    
            
                });
            }
        }}

        ></input>
    </div>
    <MovieSplashPage name={props.movieVal.title.replace(/['"]+/g, '')} 
    posterPath={props.movieVal.posterPath.replace(/['"]+/g, '')} 
    tagline={props.movieVal.tagline.replace(/['"]+/g, '')}
    overview={props.movieVal.overview.replace(/['"]+/g, '')}/>
    <div className="text-white flex overflow-x-hidden overflow-y-auto">
    {props.actorVal.map((actor)=>{
        return <div className="">
            <div className="text-white p-8 text-center">
                <Link href={"Actor/"+ actor.id}>
                    {actor.name.replace(/['"]+/g, '')} 
                </Link>
                <div className="  ">
                    <div className="">
                        <img className="" src={"https://image.tmdb.org/t/p/w500/" + actor.profilePath.replace(/['"]+/g, '')}></img>
                        <div className="text-center ">{actor.portraying}</div>
                    </div>
                </div>
            </div>
        </div>
    })};
    </div>
    <hr></hr>
    <div className="text-white">Titles Related to Search: <i>{props.movieVal.title}</i></div>    



    </>
    

}

export async function getServerSideProps(context){
    console.log(context.query.id);
    const result = await fetch("http://localhost:8080/movie/byID", {method:'GET',
    headers:{
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'id' : context.query.id
    }});
    const movieVal = await result.json();
    const result2 = await fetch("http://localhost:8080/actor/SearchForMediaPage",
        {method:'GET',
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'id' : movieVal.id,
        }

    });
    const actorVal = await result2.json();
    return {props : {movieVal, actorVal}}
}