import Banner from "@/components/Banner"
import GenreTab from "@/components/GenreTab"
import MediaPreview from "@/components/MediaPreviewer"
import SearchBar from "@/components/SearchBar"
export default function Home() {
  return (
    <><Banner/><SearchBar/><div className=""><div className="w-PreviewCardWidth text-center text-offgray text-2xl border-2">Three "What Was He Cooking?" Moments
    </div>
    <MediaPreview/><MediaPreview/>
    </div><GenreTab/></>
  )
}
