<map version="freeplane 1.6.0">
<!--To view this file, download free mind mapping software Freeplane from http://freeplane.sourceforge.net -->
<node FOLDED="false" ID="ID_1429095768" CREATED="1506390598580" MODIFIED="1507863764548" COLOR="#cccccc" BACKGROUND_COLOR="#333333" STYLE="bubble"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <h2>
      Simple Legends Observer Design
    </h2>
  </body>
</html>
</richcontent>
<hook NAME="MapStyle">
    <properties fit_to_viewport="false" edgeColorConfiguration="#808080ff,#ff0000ff,#0000ffff,#00ff00ff,#ff00ffff,#00ffffff,#7c0000ff,#00007cff,#007c00ff,#7c007cff,#007c7cff,#7c7c00ff"/>

<map_styles>
<stylenode LOCALIZED_TEXT="styles.root_node" STYLE="oval" UNIFORM_SHAPE="true" VGAP_QUANTITY="24.0 pt">
<font SIZE="24"/>
<stylenode LOCALIZED_TEXT="styles.predefined" POSITION="right" STYLE="bubble">
<stylenode LOCALIZED_TEXT="default" ICON_SIZE="12.0 pt" COLOR="#000000" STYLE="fork">
<font NAME="SansSerif" SIZE="10" BOLD="false" ITALIC="false"/>
</stylenode>
<stylenode LOCALIZED_TEXT="defaultstyle.details"/>
<stylenode LOCALIZED_TEXT="defaultstyle.attributes">
<font SIZE="9"/>
</stylenode>
<stylenode LOCALIZED_TEXT="defaultstyle.note" COLOR="#000000" BACKGROUND_COLOR="#ffffff" TEXT_ALIGN="LEFT"/>
<stylenode LOCALIZED_TEXT="defaultstyle.floating">
<edge STYLE="hide_edge"/>
<cloud COLOR="#f0f0f0" SHAPE="ROUND_RECT"/>
</stylenode>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.user-defined" POSITION="right" STYLE="bubble">
<stylenode LOCALIZED_TEXT="styles.topic" COLOR="#18898b" STYLE="fork">
<font NAME="Liberation Sans" SIZE="10" BOLD="true"/>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.subtopic" COLOR="#cc3300" STYLE="fork">
<font NAME="Liberation Sans" SIZE="10" BOLD="true"/>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.subsubtopic" COLOR="#669900">
<font NAME="Liberation Sans" SIZE="10" BOLD="true"/>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.important">
<icon BUILTIN="yes"/>
</stylenode>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.AutomaticLayout" POSITION="right" STYLE="bubble">
<stylenode LOCALIZED_TEXT="AutomaticLayout.level.root" COLOR="#000000" STYLE="oval" SHAPE_HORIZONTAL_MARGIN="10.0 pt" SHAPE_VERTICAL_MARGIN="10.0 pt">
<font SIZE="18"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,1" COLOR="#0033ff">
<font SIZE="16"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,2" COLOR="#00b439">
<font SIZE="14"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,3" COLOR="#990000">
<font SIZE="12"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,4" COLOR="#111111">
<font SIZE="10"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,5"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,6"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,7"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,8"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,9"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,10"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,11"/>
</stylenode>
</stylenode>
</map_styles>
</hook>
<edge STYLE="linear"/>
<node LOCALIZED_STYLE_REF="defaultstyle.floating" POSITION="right" ID="ID_1545356606" CREATED="1507307255959" MODIFIED="1507307943669" HGAP_QUANTITY="194.99999418854725 pt" VSHIFT_QUANTITY="-293.2499912604692 pt"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      The &quot;<b>ZOOM SLIDER</b>&quot; should communicate to the &quot;<b>model</b>&quot; of any changes, and in contrast, the &quot;<b>model</b>&quot; should update our <b>view</b>&#160; of any changes made in game...
    </p>
  </body>
</html>
</richcontent>
<arrowlink SHAPE="LINEAR_PATH" COLOR="#000000" WIDTH="2" TRANSPARENCY="200" FONT_SIZE="10" FONT_FAMILY="SansSerif" DESTINATION="ID_1430713989" MIDDLE_LABEL="Zoom Slider" STARTINCLINATION="0;-23;" ENDINCLINATION="0;-26;" STARTARROW="DEFAULT" ENDARROW="DEFAULT"/>
<hook NAME="FreeNode"/>
</node>
<node POSITION="right" ID="ID_630058507" CREATED="1506390625156" MODIFIED="1507835529413" HGAP_QUANTITY="326.0 px" VSHIFT_QUANTITY="-271.0 px"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      
    </p>
    <center>
      <h2>
        View Concept
      </h2>
      <br />
      <img src="../images/concept_image.png" />
    </center>
  </body>
</html>
</richcontent>
<edge STYLE="horizontal"/>
<cloud COLOR="#f0f0f0" SHAPE="ROUND_RECT"/>
<node ID="ID_1430713989" CREATED="1506552809446" MODIFIED="1507835529413" HGAP_QUANTITY="24.0 px" VSHIFT_QUANTITY="-4.0 px"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <p style="text-align: center">
      <font size="5"><b><u>View Controls</u></b></font>
    </p>
    <p style="text-align: left">
      <font size="4"><b>1.)</b>&#160;Zoom slider</font>
    </p>
    <ul>
      <li>
        <font size="3">The mouse wheel should control this</font>
      </li>
    </ul>
    <p>
      <font size="4"><b>2.)</b>&#160;Health Progress Bar</font>
    </p>
    <ul>
      <li>
        <font size="3">Make this into a button that opens another view </font>
      </li>
      <li>
        <font size="3">The idea is to create a macro for when a certain health is reached</font>
      </li>
    </ul>
    <p>
      <font size="4"><b>3.)</b>&#160;Credits Button</font>
    </p>
    <ul>
      <li>
        <font size="3">The &quot;Credits to Abhi&quot; button should open meatspin ;)</font>
      </li>
    </ul>
  </body>
</html>
</richcontent>
<edge STYLE="horizontal"/>
<cloud COLOR="#f0f0f0" SHAPE="ROUND_RECT"/>
</node>
</node>
<node LOCALIZED_STYLE_REF="defaultstyle.floating" POSITION="right" ID="ID_1867465743" CREATED="1507307487751" MODIFIED="1507308029887" HGAP_QUANTITY="194.9999941885473 pt" VSHIFT_QUANTITY="-232.49999307096024 pt"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      The &quot;<b>Health Progress Bar's</b>&quot; view should notify the &quot;<b>model</b>&quot; of new changes for set macros/health. Otherwise this view should only receive updates from the &quot;<b>model</b>&quot; with changes from in-game.
    </p>
  </body>
</html>
</richcontent>
<arrowlink SHAPE="LINEAR_PATH" COLOR="#000000" WIDTH="2" TRANSPARENCY="200" FONT_SIZE="10" FONT_FAMILY="SansSerif" DESTINATION="ID_1430713989" MIDDLE_LABEL="Health Progress Bar" STARTINCLINATION="0;-123;" ENDINCLINATION="0;-43;" STARTARROW="DEFAULT" ENDARROW="DEFAULT"/>
<hook NAME="FreeNode"/>
</node>
<node LOCALIZED_STYLE_REF="defaultstyle.floating" POSITION="right" ID="ID_931677887" CREATED="1507307954063" MODIFIED="1507308085350" HGAP_QUANTITY="194.24999421089905 pt" VSHIFT_QUANTITY="-156.7499953284861 pt"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      The &quot;<b>Credits Button</b>&quot; should only communicate to the &quot;<b>model</b>&quot; when the button was clicked.
    </p>
  </body>
</html>
</richcontent>
<arrowlink SHAPE="LINEAR_PATH" COLOR="#000000" WIDTH="2" TRANSPARENCY="200" FONT_SIZE="10" FONT_FAMILY="SansSerif" DESTINATION="ID_1430713989" MIDDLE_LABEL="Credits Button" STARTINCLINATION="1;-244;" ENDINCLINATION="0;-65;" STARTARROW="DEFAULT" ENDARROW="DEFAULT"/>
<hook NAME="FreeNode"/>
</node>
<node LOCALIZED_STYLE_REF="defaultstyle.floating" POSITION="right" ID="ID_980365792" CREATED="1507835700085" MODIFIED="1507862337371" HGAP_QUANTITY="-29.999999105930378 pt" VSHIFT_QUANTITY="152.24999546259653 pt"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      &lt;&lt;class&gt;&gt; <b>LolSimple</b>&#160;(main method)
    </p>
  </body>
</html>
</richcontent>
<arrowlink SHAPE="LINE" COLOR="#000000" WIDTH="2" TRANSPARENCY="200" FONT_SIZE="9" FONT_FAMILY="SansSerif" DESTINATION="ID_309378122" MIDDLE_LABEL="launch(class, args)" STARTINCLINATION="475;0;" ENDINCLINATION="475;0;" STARTARROW="NONE" ENDARROW="DEFAULT"/>
<hook NAME="FreeNode"/>
</node>
<node TEXT="&lt;&lt;interface&gt;&gt; Subject" LOCALIZED_STYLE_REF="defaultstyle.floating" POSITION="right" ID="ID_1089586735" CREATED="1507835881932" MODIFIED="1507862312921" HGAP_QUANTITY="217.49999351799502 pt" VSHIFT_QUANTITY="152.99999544024482 pt">
<arrowlink SHAPE="LINE" COLOR="#000000" WIDTH="2" TRANSPARENCY="200" DASH="3 3" FONT_SIZE="9" FONT_FAMILY="SansSerif" DESTINATION="ID_1644240577" MIDDLE_LABEL="implements" STARTINCLINATION="292;0;" ENDINCLINATION="292;0;" STARTARROW="NONE" ENDARROW="DEFAULT"/>
<arrowlink SHAPE="LINE" COLOR="#000000" WIDTH="2" TRANSPARENCY="200" DASH="3 3" FONT_SIZE="9" FONT_FAMILY="SansSerif" DESTINATION="ID_428842248" MIDDLE_LABEL="implements" STARTINCLINATION="575;0;" ENDINCLINATION="575;0;" STARTARROW="NONE" ENDARROW="DEFAULT"/>
<hook NAME="FreeNode"/>
</node>
<node TEXT="&lt;&lt;interface&gt;&gt; Observer" LOCALIZED_STYLE_REF="defaultstyle.floating" POSITION="right" ID="ID_1430380997" CREATED="1507835853773" MODIFIED="1507862842439" HGAP_QUANTITY="-178.49999468028565 pt" VSHIFT_QUANTITY="153.74999541789305 pt">
<arrowlink SHAPE="LINEAR_PATH" COLOR="#000000" WIDTH="2" TRANSPARENCY="200" DASH="3 3" FONT_SIZE="9" FONT_FAMILY="SansSerif" DESTINATION="ID_1618184644" MIDDLE_LABEL="implements" STARTINCLINATION="-291;0;" ENDINCLINATION="-103;0;" STARTARROW="NONE" ENDARROW="DEFAULT"/>
<arrowlink SHAPE="LINEAR_PATH" COLOR="#000000" WIDTH="2" TRANSPARENCY="200" DASH="3 3" FONT_SIZE="9" FONT_FAMILY="SansSerif" DESTINATION="ID_276661304" MIDDLE_LABEL="implements" STARTINCLINATION="-235;0;" ENDINCLINATION="-46;-1;" STARTARROW="NONE" ENDARROW="DEFAULT"/>
<arrowlink SHAPE="LINE" COLOR="#000000" WIDTH="2" TRANSPARENCY="200" DASH="3 3" FONT_SIZE="9" FONT_FAMILY="SansSerif" DESTINATION="ID_305601403" MIDDLE_LABEL="implements" STARTINCLINATION="458;0;" ENDINCLINATION="458;0;" STARTARROW="NONE" ENDARROW="DEFAULT"/>
<hook NAME="FreeNode"/>
</node>
<node TEXT="View" LOCALIZED_STYLE_REF="defaultstyle.floating" POSITION="right" ID="ID_1794020368" CREATED="1507835572709" MODIFIED="1507862764415" HGAP_QUANTITY="-267.74999202042846 pt" VSHIFT_QUANTITY="233.2499930486086 pt" STYLE="bubble">
<hook NAME="FreeNode"/>
<node TEXT="&lt;&lt;class&gt;&gt; LolSimpleView" ID="ID_309378122" CREATED="1507838825240" MODIFIED="1507846424260" HGAP_QUANTITY="-78.24999725073585 pt" VSHIFT_QUANTITY="48.749998547136826 pt"/>
<node TEXT="&lt;&lt;class&gt;&gt; LolSimpleZoomListener" ID="ID_428842248" CREATED="1507846252240" MODIFIED="1507846268814" HGAP_QUANTITY="-78.99999722838409 pt" VSHIFT_QUANTITY="6.749999798834329 pt"/>
<node TEXT="&lt;&lt;class&gt;&gt; LolSimpleZoomObserver" ID="ID_1618184644" CREATED="1507862744679" MODIFIED="1507863247830" HGAP_QUANTITY="-77.49999727308759 pt" VSHIFT_QUANTITY="5.99999982118607 pt">
<arrowlink SHAPE="LINEAR_PATH" COLOR="#000000" WIDTH="2" TRANSPARENCY="200" FONT_SIZE="9" FONT_FAMILY="SansSerif" DESTINATION="ID_1917646225" MIDDLE_LABEL="subscribed" STARTINCLINATION="65;0;" ENDINCLINATION="-204;0;" STARTARROW="NONE" ENDARROW="DEFAULT"/>
</node>
<node TEXT="&lt;&lt;class&gt;&gt; LolSimpleHealthObserver" ID="ID_305601403" CREATED="1507846407145" MODIFIED="1507862974134" HGAP_QUANTITY="-78.9999972283841 pt" VSHIFT_QUANTITY="9.749999709427366 pt">
<arrowlink SHAPE="LINEAR_PATH" COLOR="#000000" WIDTH="2" TRANSPARENCY="200" FONT_SIZE="9" FONT_FAMILY="SansSerif" DESTINATION="ID_613963232" MIDDLE_LABEL="subscribed" STARTINCLINATION="51;0;" ENDINCLINATION="-213;0;" STARTARROW="NONE" ENDARROW="DEFAULT"/>
</node>
<node TEXT="&lt;&lt;class&gt;&gt; LolSimpleGameObserver" ID="ID_276661304" CREATED="1507861720169" MODIFIED="1507931623273" HGAP_QUANTITY="-78.24999725073585 pt" VSHIFT_QUANTITY="8.249999754130847 pt">
<arrowlink SHAPE="CUBIC_CURVE" COLOR="#000000" WIDTH="2" TRANSPARENCY="200" FONT_SIZE="9" FONT_FAMILY="SansSerif" DESTINATION="ID_1644240577" MIDDLE_LABEL="subscribed" STARTINCLINATION="56;-5;" ENDINCLINATION="-197;0;" STARTARROW="NONE" ENDARROW="DEFAULT"/>
</node>
</node>
<node TEXT="Model" LOCALIZED_STYLE_REF="defaultstyle.floating" POSITION="right" ID="ID_1151931369" CREATED="1507838744633" MODIFIED="1507937126450" HGAP_QUANTITY="79.49999763071543 pt" VSHIFT_QUANTITY="284.2499915286901 pt" STYLE="bubble">
<hook NAME="FreeNode"/>
<node TEXT="&lt;&lt;class&gt;&gt; LolSimpleModel" ID="ID_484017503" CREATED="1507845686391" MODIFIED="1507863025206" HGAP_QUANTITY="-71.4999974519015 pt" VSHIFT_QUANTITY="56.99999830126767 pt"/>
<node TEXT="&lt;&lt;class&gt;&gt; LolSimpleCheckForGame" ID="ID_1644240577" CREATED="1507845646639" MODIFIED="1507930480901" HGAP_QUANTITY="-73.7499973848463 pt" VSHIFT_QUANTITY="7.499999776482592 pt"/>
<node TEXT="&lt;&lt;class&gt;&gt; LolSimpleHealth" ID="ID_613963232" CREATED="1507862202544" MODIFIED="1507862928862" HGAP_QUANTITY="-71.49999745190152 pt" VSHIFT_QUANTITY="5.999999821186072 pt">
<arrowlink SHAPE="LINEAR_PATH" COLOR="#000000" WIDTH="2" TRANSPARENCY="200" DASH="3 3" FONT_SIZE="9" FONT_FAMILY="SansSerif" DESTINATION="ID_1089586735" MIDDLE_LABEL="implements" STARTINCLINATION="233;0;" ENDINCLINATION="27;0;" STARTARROW="DEFAULT" ENDARROW="NONE"/>
</node>
<node TEXT="&lt;&lt;class&gt;&gt; LolSimpleZoomInGame" ID="ID_1917646225" CREATED="1507862717215" MODIFIED="1507863181535" HGAP_QUANTITY="-69.99999749660499 pt" VSHIFT_QUANTITY="3.7499998882412946 pt">
<arrowlink SHAPE="LINEAR_PATH" COLOR="#000000" WIDTH="2" TRANSPARENCY="200" DASH="3 3" FONT_SIZE="9" FONT_FAMILY="SansSerif" DESTINATION="ID_1089586735" MIDDLE_LABEL="implements" STARTINCLINATION="269;0;" ENDINCLINATION="104;0;" STARTARROW="DEFAULT" ENDARROW="NONE"/>
</node>
<node TEXT="&lt;&lt;class&gt;&gt; LolSimpleUpdateGameZoom" ID="ID_363797077" CREATED="1507863015638" MODIFIED="1507931049549" HGAP_QUANTITY="-69.24999751895673 pt" VSHIFT_QUANTITY="6.74999979883433 pt">
<arrowlink SHAPE="LINEAR_PATH" COLOR="#000000" WIDTH="2" TRANSPARENCY="200" DASH="3 3" FONT_SIZE="9" FONT_FAMILY="SansSerif" DESTINATION="ID_1430380997" MIDDLE_LABEL="implements" STARTINCLINATION="-546;0;" ENDINCLINATION="-252;0;" STARTARROW="DEFAULT" ENDARROW="NONE"/>
<arrowlink SHAPE="LINEAR_PATH" COLOR="#000000" WIDTH="2" TRANSPARENCY="200" FONT_SIZE="9" FONT_FAMILY="SansSerif" DESTINATION="ID_428842248" MIDDLE_LABEL="subscribed" STARTINCLINATION="-595;0;" ENDINCLINATION="-112;0;" STARTARROW="NONE" ENDARROW="DEFAULT"/>
</node>
<node TEXT="&lt;&lt;class&gt;&gt; LolSimpleDLL (Singleton Object)" ID="ID_837090340" CREATED="1507934970972" MODIFIED="1508020575847" HGAP_QUANTITY="-68.49999754130847 pt" VSHIFT_QUANTITY="4.499999865889553 pt"/>
</node>
<node POSITION="left" ID="ID_1563417624" CREATED="1506553621806" MODIFIED="1507863743033" HGAP_QUANTITY="-131.0 px" VSHIFT_QUANTITY="89.0 px"><richcontent TYPE="NODE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      <font size="4">Code Design</font>
    </p>
  </body>
</html>
</richcontent>
<arrowlink SHAPE="LINEAR_PATH" COLOR="#000000" WIDTH="2" TRANSPARENCY="200" FONT_SIZE="14" FONT_FAMILY="SansSerif" DESTINATION="ID_980365792" MIDDLE_LABEL="start" STARTINCLINATION="-103;0;" ENDINCLINATION="52;0;" STARTARROW="NONE" ENDARROW="DEFAULT"/>
<edge STYLE="horizontal"/>
<cloud COLOR="#f0f0f0" SHAPE="ROUND_RECT"/>
</node>
</node>
</map>
