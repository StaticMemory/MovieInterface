import { useRouter } from "next/router";

export default function User(props){
    const router = useRouter();
    
    return <div className="text-white">{router.query.user}</div>
}
export function getServerSideProps(context){
    return {props};
}