# HighlightGuideView
A custom view that provides beginner's highlighting guide

![sample](https://github.com/ShonLin/HighlightGuideView/blob/master/sample.gif)

## import
Download project, copy [HighlightGuideView.java](https://github.com/ShonLin/HighlightGuideView/blob/master/library/src/main/java/com/linxiao/library/HighlightGuideView.java)
to your project, use and edit it as you need : )  

## usage

### single highlight guide
```
  HighlightGuideView.newInstance(activity) // create a HighlightGuideView
```
use image guide
```java
  HighlightGuideView.newInstance(this)
  .setHighlightStyle(HighlightGuideView.STYLE_CIRCLE)
  .addTargetView(targetView)
  .addGuideImage(targetView, // view that need highlight guide
      R.drawable.ic_arrow,   // drawable resources, could be AnimationDrawable
      dp2px(100),            // image width
      dp2px(50),             // image height
      dp2px(50),             // The X coordinate of the image relative to the target
      0                      // The Y coordinate of the picture relative to the target
  )
  .show();
```
use view guide

```java
/* 
  a sample to get a view in java code, you can use any way 
  such as LayoutInflater to get a view and use it in HighlightGuideView
*/  
    TextView tvDesc = new TextView(this);
    tvDesc.setTextColor(ContextCompat.getColor(this, android.R.color.white));
    tvDesc.setText("guide 1");
    tvDesc.setTextSize(16);
    
    HighlightGuideView.newInstance(this)
    .setHighlightStyle(HighlightGuideView.STYLE_OVAL)
    .addTargetView(btnShowQueue)
    .addGuideView(btnShowQueue, tvDesc3, dp2px(50), dp2px(60))
    .show();
```

### multiple highlight guide
In some cases, you may need to set up multiple guide pages and display them in turn, 
you can use GuideQueue to handle this situation.  

example
```java
    HighlightGuideView.GuideQueue queue = HighlightGuideView.newGuideQueue();
    queue.add(highlightGuideView1);
    queue.add(highlightGuideView2);
    ......
    queue.show();
```
The GuideQueue will display the guide pages according to the order in which the pages are added, 
automatically display the next page after the previous page dismissed.

## LICENSE
    Copyright 2017 linxiao

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
