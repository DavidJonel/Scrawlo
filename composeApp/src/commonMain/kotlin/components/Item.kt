package components

sealed class Item {
    data class FolderItem(
        val name : String,
        val children: List<Item>,
        val parentId: Long? = null
    ) : Item()

    data class File(
        val name: String,
        val content: String,
        val parentId: Long? = null
    ) : Item()
}

fun generateDummyData(): Item.FolderItem {
    // Creating files for the dummy folders
    val file1 = Item.File(name = "Document1.txt", content = "This is the content of Document1.")
    val file2 = Item.File(name = "Document2.txt", content = "This is the content of Document2.")
    val file3 = Item.File(name = "Notes.md", content = "# Markdown Notes\nSome notes content")

    // Creating subfolders
    val subFolder1 = Item.FolderItem(
        name = "SubFolder1",
        children = listOf(
            Item.File(name = "SubDoc1.txt", content = "This is SubFolder1's document."),
            Item.File(name = "SubDoc2.txt", content = "Another document in SubFolder1.")
        )
    )

    val subFolder2 = Item.FolderItem(
        name = "SubFolder2",
        children = listOf(
            Item.File(name = "SubNotes.md", content = "## SubFolder2 Notes\nMore notes."),
            Item.File(name = "Image1.png", content = "") // Example of non-text file
        )
    )

    // Root folder with subfolders and files
    return Item.FolderItem(
        name = "RootFolder",
        children = listOf(
            file1,
            file2,
            file3,
            subFolder1,
            subFolder2
        )
    )
}





