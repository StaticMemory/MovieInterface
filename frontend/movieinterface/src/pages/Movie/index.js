import Banner from "@/components/Banner";
import { useState } from "react";
import { useRouter } from "next/router";
import MovieSplashPage from "@/components/MovieSplashPage";
import Link from "next/link";
import ReviewPanel from "@/components/Review";
import { useSession } from "next-auth/react";
import IsLoggedInForReview from "@/components/IsLoggedInForReview";
export default function Movie(props){
    const router = useRouter();
    const [searchOption, setSearchOption] = useState("");
    const {data : session} = useSession();
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
    <div className="text-white  flex overflow-x-hidden">
    {props.actorVal.map((actor, id)=>{
        return <div key={id}className="">
            <div className="text-white p-8 text-center ">
                <Link href={"Actor/"+ actor.id}>
                    {actor.name.replace(/['"]+/g, '')} 
                </Link>
                <div className="  ">
                    <div className="">
                        <img className="" src={"https://image.tmdb.org/t/p/w500/" + actor.profilePath.replace(/['"]+/g, '')} alt="No image found"></img>
                        <div className="text-center ">{actor.portraying}</div>
                    </div>
                </div>
            </div>
        </div>
    })}
    </div>
    <hr></hr>
    {//<div className="text-white">Titles Related to Search: <i>{props.movieVal.title}</i></div>
}
    
    <div className="text-white text-center p-2">User Submitted Reviews</div>
    <IsLoggedInForReview id={props.movieVal.id} type={'0'}></IsLoggedInForReview>
    <ReviewPanel/>
    </>
    

}

export async function getServerSideProps(context){
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
    const reviewList = await fetch("http://localhost:8080/media/returnSpecificMediaReview", {method:'GET',
    headers:{
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'id' : context.query.id,
        'mediaType' : "0"
    }    
})
    const actorVal = await result2.json();
    const reviewData = await reviewList.json();
    return {props : {movieVal, actorVal, reviewData}}
}