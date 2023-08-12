import Banner from "@/components/Banner";
import { useState } from "react";
import { useRouter } from "next/router";
export default function actorByID(props){
    const[searchOption, setSearchOption] = useState("");
    const router = useRouter();
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
    <br></br>
    <div className="flex text-white">
        <div>
            <div className="text-white "> {props.result2.name.replace(/['"]+/g, '')}</div>
            <img src={"https://image.tmdb.org/t/p/w500/" + props.result2.profilePath.replace(/['"]+/g, '')} height={100} width={200}></img>
        </div>
        <div>{props.result2.biography}</div>
    </div>
  </>
}
export async function getServerSideProps(context){
    const request = await fetch("http://localhost:8080/actor/searchByIDMovieCredits", {method : 'GET',
        headers: {'Accept': 'application/json',
        'Content-Type': 'application/json',
        'id' : context.query.id}
});
    const actorReq = await fetch("http://localhost:8080/actor/getSingleActorByID", {method : 'GET',
    headers: {'Accept': 'application/json',
    'Content-Type': 'application/json',
    'id' : context.query.id}
});
    const result = await request.json();
    const result2 = await actorReq.json();
    return {props : {result, result2}};
}