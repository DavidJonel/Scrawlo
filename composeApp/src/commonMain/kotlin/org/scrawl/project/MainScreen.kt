package org.scrawl.project

import androidx.compose.runtime.Composable

@Composable
fun MainScreen(){
    val isAndroid = getPlatform().name == PlatformType.ANDROID

    if(isAndroid){
        AndroidMain()
    } else{
        DesktopMain()
    }

}





//@Composable
//fun TextScreen(){
//
//    val isAndroid = getPlatform().name == PlatformType.ANDROID
//    var isCollapsed by remember { mutableStateOf(false) }
//
//    val folder = generateDummyData() //dum dum
//    var text by remember { mutableStateOf(TextFieldValue("")) }
//
//
//    Row(modifier = Modifier
//        .fillMaxSize()
//        .height(IntrinsicSize.Max),
//        horizontalArrangement = Arrangement.SpaceEvenly
//    ){
//
//        AnimatedVisibility(
//            visible = !isCollapsed,
//            enter = slideInHorizontally(initialOffsetX = { -it }),
//            exit = slideOutHorizontally(targetOffsetX = { -it }),
//
//            ) {
//            Column(
//                modifier = Modifier
//                    .background(MaterialTheme.colorScheme.surfaceContainer)
//                    .padding(20.dp)
//                    .fillMaxHeight(),
//                verticalArrangement = Arrangement.Top
//            ) {
//                Row(
//                    horizontalArrangement = Arrangement.spacedBy(64.dp),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Text("Projects")
//
//                    Row{
//                        IconButton(onClick = { /* Handle add folder */ }, modifier = Modifier) {
//                            Icon(imageVector = Icons.Outlined.Add, contentDescription = "Add")
//                        }
//                        if(isAndroid){
//                            IconButton(onClick = { isCollapsed = true }) {
//                                Icon(
//                                    imageVector = Icons.Outlined.KeyboardDoubleArrowLeft,
//                                    contentDescription = "Collapse"
//                                )
//                            }
//                        }
//                    }
//
//                }
//                Folder(folder)
//            }
//        }
//        if (isAndroid && isCollapsed) {
//            IconButton(
//                onClick = { isCollapsed = false },
//                modifier = Modifier
//                    .align(Alignment.Top)
//            ) {
//                Icon(
//                    imageVector = Icons.Outlined.KeyboardDoubleArrowRight,
//                    contentDescription = "Expand"
//                )
//            }
//        }
//
//        Box(modifier = Modifier.fillMaxHeight()){
//            Column(modifier = Modifier.padding(24.dp), verticalArrangement = Arrangement.SpaceBetween) {
//                TransparentTextField(
//                    "",
//                    textValue = text.text,
//                    onValueChange = {NewBody -> text = NewBody},
//                    labelSize = 14.sp,
//                    modifier = Modifier.fillMaxSize()
//                )
//
//            }
//        }
//
//
//    }
//
//}
