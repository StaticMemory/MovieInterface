import Banner from "@/components/Banner";
import SearchResult from "@/components/SearchResult";
import ActorResult from "@/components/actorSearchResult";
import { useRouter } from "next/router";
import React from "react";

import { useState } from "react";

function renderResults(title, imagePath){
    return <>
    <div className="w-MovieSearchWidth">
        <Link href="/Series?&title=dark " className="w-MovieSearchWidth">
            <div className="text-white flex w-MovieSearchWidth border-2">
                <div>
                    <div className="text-center italic font-bold underline w-64">{title}
                        <div className="h-full">
                            <img src={"https://image.tmdb.org/t/p/w500/"+imagePath} className="h-64 w-full"></img>
                        </div>
                    </div>
                </div>
            </div>
        </Link>
    </div></>
}

export default function Search(props){
    console.log(props.jsonDataActors);
    const router = useRouter();
    const [searchOption, setSearchOption] = useState("");
    return <React.Fragment>
    <Banner></Banner>
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
    <div className="text-center">
        <div className="text-white">Showing Search Results for Search Request: <i>{router.query.searchResult}</i></div>
    </div>
    <div className="flex">
        <div className="pr-3">
            <div className="p-2">
                <div className="text-center ml-auto mr-auto border-2 rounded border-gray-800 w-fit p-2 bg-gray-500">Movies</div>
            </div>
        <div>
        {(props.jsonDataMovie).map((movie) => {
                return <><SearchResult key={movie.id} name={movie.original_title} isMovie={true} isTV={false} isActor={false} id={movie.id} 
                imagePath={movie.poster_path} info={movie.overview}></SearchResult>
                <br></br>
                </>
            })}
            </div>
        </div>
        <div className="pr-3">
            <div className="p-2">
                <div className="text-center ml-auto mr-auto border-2 rounded border-gray-800 w-fit p-2 bg-gray-500">TV Series</div>
            </div>
        <div>
            {(props.jsonDataTVSeries).map((tv) => {
                    return <>
                    <SearchResult key={tv.id} name={tv.name} isActor={false} isTV={true} isMovie={false} id={tv.id} imagePath={tv.poster_path} info={tv.overview}></SearchResult>
                    <br></br>
                    </>
                })}
            </div>
        </div>
        <div>
        <div className="p-2">
            <div className="text-center ml-auto mr-auto border-2 rounded border-gray-800 w-fit p-2 bg-gray-500">Actors</div>
        </div>
        <div>
                {(props.jsonDataActors).map((actor) => {
                    return <><div>
                        <ActorResult name={actor['name'].replace(/['"]+/g, '')} profile={actor['profilePath'].replace(/['"]+/g, '')} id={actor['id'].replace(/['"]+/g, '')}/>
                        </div></>
                })};
            </div>
        </div>
    </div>
    
    </React.Fragment>
}


export async function getServerSideProps(context){
    //const router = useRouter();
    const result = await fetch("http://localhost:8080/movie/BySearch",
        {method:'GET',
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'title' : context.query.searchResult,
            'page' : '1'
        }

    });
    const result2 = await fetch("http://localhost:8080/TV/BySearch",
        {method:'GET',
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'title' : context.query.searchResult,
            'page' : '1'
        }

    });
    const result3 = await fetch("http://localhost:8080/actor/bySearch", {method : 'GET',
headers:{
    'Accept': 'application/json',
            'Content-Type': 'application/json',
            'name' : context.query.searchResult,
            'page' : '1'
}});
    const jsonDataMovie =await result.json();
    const jsonDataTVSeries = await result2.json();
    const jsonDataActors = await result3.json();
    return {props : {jsonDataMovie, jsonDataTVSeries, jsonDataActors}};

    
}
