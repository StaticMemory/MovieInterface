import Banner from "@/components/Banner";
import SearchBar from "@/components/SearchBar";
import SearchResult from "@/components/SearchResult";
import { useRouter } from "next/router";
import queryString from 'query-string'



export default function Search(){
    const router = useRouter();
    console.log(router.asPath);
    return <>
    <Banner></Banner>
    <SearchBar/>
    <div className="text-center">
        <div className="text-white">Showing Search Results for Search Request: <i>Standin</i></div>
    </div>
    <div className="text-white text-center text-3xl underline">Movies:</div>
    <SearchResult/>
    <div className="text-white text-center text-3xl underline"> TV Series</div>
    <SearchResult/>
    <div className="text-white text-center text-3xl underline">Actors</div>
    
    
    </>
}