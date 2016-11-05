# InvisibleSheild
# 隱形遁
國道測速照機位置相提示APP  
<img src="https://github.com/slk1107/InvisibleSheild/blob/master/ReadHtml/app/src/main/res/drawable/intro.png" width="288" height="512" />
<img src="https://github.com/slk1107/InvisibleSheild/blob/master/ReadHtml/app/src/main/res/drawable/title.png" width="288" height="512" />
<h3> Usage<br>
 用法 </h3>
 1.選擇自己身處國道<br>
 2.顯示高速公路測速照相機地點公里數
 
 <h3> Tech<br>
 技術 </h3>
1. <code>gridview</code><br>
       利用<code>gridview</code>讓使用者可以輕易地點選所在高速公路，也方便日後增加路線維護。        
2. <code>Alertdialog</code><br>
       彈跳視窗讓使用者可以自行選擇所行進方向(東南西北)，再將使用者所選擇的"國道"+"方向"化為tag字串，進而調出相對應的xhtml檔案名稱。               
3. <code>webview</code><br>
       利用<code>webview</code>去呈現資料<br>
       因為此APP並非連續注視型，使用者可能只須看過一個公里數，10分鐘後才會需要再看下一個公里數。<br>
       像如果用傳統的"scroll"手勢，常常增加使用者找資料的困難度。<br>
4. <code>column width</code><br>
       為了解決第3點提到的問題，我將<code>webview</code>搭配CSS的排版，讓<code>webview</code>以【頁】的方式呈現<br>
5. <code>scroll by</code><br>
       最後再利用 Jacascript的<code>scroll by</code>做出翻頁的感覺，如此一來，就可以達成使用者在單手操作的情況下可以輕鬆地翻到下一頁，也不會造成因為scroll而產生的混亂感。
   

