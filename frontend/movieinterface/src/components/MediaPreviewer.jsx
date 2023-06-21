import Link from 'next/link'
import maxresdefault from '../images/maxresdefault.jpg'
import Image from "next/image"
export default function MediaPreview(){
    return <><div className=" w-PreviewCardWidth h-64 border-gray-800 border-2"> <div className=" h-8 text-center text-white">
    <Link href="hi">What was he cooking</Link></div><div className='flex text-white'>
    <Image className='border-2 border-gray-700' src={maxresdefault}
    width={300}
    height={300}></Image> Here</div></div></>
}