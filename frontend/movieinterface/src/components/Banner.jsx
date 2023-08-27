import React from "react";
import { Session} from "next-auth";
import { useSession, signOut, signIn } from "next-auth/react";
export default function Banner(){
    const {data : session} = useSession();
    if(session){
        return <div>
            <div className="justify-center items-center flex text-gray-100">This product uses the TMDB API but is not endorsed or certified by TMDB
            <header className="text-center p-4 bg-defaultColour w-full  text-3xl text-offgray font-black outline-black">Modern Media Trawler</header>
            <div>Logged in as: {session['user']['name']}</div>
            <div><button onClick={()=>{
                signOut();
            }}>Sign Out</button></div>
            </div>


        </div>
    }
    return <React.Fragment>
        <div className="justify-center items-center flex text-gray-100">This product uses the TMDB API but is not endorsed or certified by TMDB
        <header className="text-center p-4 bg-defaultColour w-full  text-3xl text-offgray font-black outline-black">Modern Media Trawler</header>
        <button className="text-white" onClick={()=>{
            signIn();
        }}>Sign in!</button>
        </div>
    </React.Fragment>
}