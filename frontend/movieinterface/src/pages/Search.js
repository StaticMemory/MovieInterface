import Banner from "@/components/Banner";
import SearchResult from "@/components/SearchResult";
import { useRouter } from "next/router";
import queryString from 'query-string'

import { useState } from "react";

function renderResults(){
    return <>
    <div className="w-MovieSearchWidth">
        <Link href="/Series?&title=dark " className="w-MovieSearchWidth">
            <div className="text-white flex w-MovieSearchWidth border-2">
                <div>
                    <div className="text-center italic font-bold underline w-64">Dark
                        <div className="h-full">
                            <img src="https://image.tmdb.org/t/p/w500/7yQyDCqSazrYTnmxdQLAZ8YDH87.jpg" className="h-64 w-full"></img>
                        </div>
                    </div>
                </div>
            </div>
        </Link>
    </div></>
}

export default function Search(){
    const router = useRouter();
    
    console.log(router.query);
    const [searchOption, setSearchOption] = useState("");
    return <>
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
    <div className="text-white text-center text-3xl underline">Movies:</div>
    <SearchResult/>
    <div className="text-white text-center text-3xl underline"> TV Series</div>
    <SearchResult/>
    <div className="text-white text-center text-3xl underline">Actors</div>
    
    
    </>
}
