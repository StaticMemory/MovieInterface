import Banner from "@/components/Banner"
import MediaPreview from "@/components/MediaPreviewer"
import SearchBar from "@/components/SearchBar"
export default function Home() {
  return (
    <><Banner/><SearchBar/><div className=""><div className="w-PreviewCardWidth text-center text-offgray text-2xl">Top 10 What was he cooking moments</div><MediaPreview/><MediaPreview/><MediaPreview/></div></>
  )
}
