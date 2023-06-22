import { useRouter } from "next/router"
import Banner from "@/components/Banner";
import SearchBar from "@/components/SearchBar";
export default function GenrePage(props){
    const router = useRouter();
    let genre = (router.query.Genre);
    return <>
    <Banner/>
    <SearchBar/>
    <div className="border-b border-white"></div>
    <br></br>
    <div className="text-white text-center">MOVIE AND TV SHOW TITLES MATCHING GENRE: <i>{genre}</i></div>
    <br></br>
    <div className="border-b border-white"></div>
    </>
}
export function getServerSideProps(context){
    const query = context.query;
    return {props: { query }};
}