<script>
			var song;
			
			$("#song1").click(function(song) {			
			song = '<audio controls><source src="<?=$data1['Song_Location']?>" /></audio>';			
			writesong(song)
			});
			
			$("#song2").click(function(song) {			
			song = '<audio controls><source src="<?=$data2['Song_Location']?>" /></audio>';			
			writesong(song)
			});
			
			$("#song3").click(function(song) {			
			song = '<audio controls><source src="<?=$data3['Song_Location']?>" /></audio>';			
			writesong(song)
			});
			
			$("#song4").click(function(song) {			
			song = '<audio controls><source src="<?=$data4['Song_Location']?>" /></audio>';			
			writesong(song)
			});
			
			$("#song5").click(function(song) {			
			song = '<audio controls><source src="<?=$data5['Song_Location']?>" /></audio>';			
			writesong(song)
			});
		</script>
		
		<script>
			function writesong(song) {
				document.getElementById('playSong').innerHTML = song;
			}
</script>