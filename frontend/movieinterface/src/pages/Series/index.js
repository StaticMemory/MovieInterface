import Banner from "@/components/Banner";
import { useState } from "react";
import { getSeasonEpisodes, getSeriesData } from "../../../api/TV";


export default function Series(props){
    const [searchOption, setSearchOption] = useState("");
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
    
    {props.seriesStore.map((season, id1)=>{
        return <><div className="text-white text-center"key={id1}>Season {id1+1}</div>{season.map((episode,id2)=>{
            return <div className="text-white border-gray-600 w-EpisodeWidth border-2" key={id2}>
                <div className="flex">
                    <div className=" px-3">
                        <img src={"https://image.tmdb.org/t/p/w500/" + episode.stillPath} width={150} className="overflow-y-hidden"></img>
                    </div>
                    <div>
                        <div className="text-white">Episode {id2+1}</div>
                        <div className="text-white w-MovieSearchWidth">{episode.overview}</div>
                    </div>
                </div>
                
            </div>
        })}
        
        </>
    })}

    
    </>
}

export async function getServerSideProps(context){
    const data = await getSeriesData(context.query.id);
    let seriesStore = [];
    for(const season of data){
        if(season.seasonNumber !== '0'){
        seriesStore.push(await getSeasonEpisodes(context.query.id, season.seasonNumber))
        }
    }
    return {props : {seriesStore,data}}
}