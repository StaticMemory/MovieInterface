import { useRouter } from "next/router"
export default function GenrePage(props){
    const router = useRouter();
    let genre = (router.query.Genre);
    return <><div className="text-white text-center">MOVIE AND TV SHOW TITLES MATCHING GENRE: <i>{genre}</i></div></>
}
export function getServerSideProps(context){
    const query = context.query;
    return {props: { query }};
}