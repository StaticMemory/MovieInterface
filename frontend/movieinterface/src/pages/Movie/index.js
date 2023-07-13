import Banner from "@/components/Banner";
import { useState } from "react";
import { useRouter } from "next/router";
export default function Movie(){
    const router = useRouter();
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
    
    </>
}