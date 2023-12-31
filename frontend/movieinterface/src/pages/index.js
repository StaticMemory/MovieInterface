import Banner from "@/components/Banner"
import GenreTab from "@/components/GenreTab"
import MediaPreview from "@/components/MediaPreviewer"
import { useRouter } from "next/router";
import { useState } from "react"
import { useSession, signIn, signOut } from "next-auth/react";

export default function Home() {
  const {data: session} = useSession();
  const [searchOption, setSearchOption] = useState("");
  const router = useRouter();
  if(session){
  return (
    <>
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
      <div className="flex relative">
        <div>
          <div className="w-PreviewCardWidth text-center text-offgray text-2xl  p-1">Three "What Was He Cooking?" Moments</div>
          <MediaPreview/>
          <MediaPreview/>
          <MediaPreview/>
        </div>
        <div className="absolute right-0 p-16">
          <GenreTab></GenreTab>
        </div>
      </div>
      
    </>
  )}
  else{
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
      <button className="text-white" onClick={() => signIn()}>Sign in</button>
      <div className="flex relative">
        <div className="absolute right-0 p-16">
          <GenreTab></GenreTab>
        </div>
      </div>
      
    
    </>
  }
}
