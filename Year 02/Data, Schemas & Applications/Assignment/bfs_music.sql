-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 24, 2013 at 08:15 PM
-- Server version: 5.5.24-log
-- PHP Version: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bfs_music`
--

-- --------------------------------------------------------

--
-- Table structure for table `album`
--

CREATE TABLE IF NOT EXISTS `album` (
  `Album_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Artist_ID` int(11) NOT NULL,
  `Album_Name` varchar(30) NOT NULL,
  PRIMARY KEY (`Album_ID`),
  KEY `Artist_ID` (`Artist_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `album`
--

INSERT INTO `album` (`Album_ID`, `Artist_ID`, `Album_Name`) VALUES
(1, 1, 'Leave A Whisper'),
(2, 1, 'Us And Them'),
(3, 1, 'The Sound Of Madness'),
(4, 1, 'Amaryllis'),
(5, 2, 'House Of Gold And Bones'),
(6, 3, 'Apocalyptic Love'),
(7, 4, 'New Horizons'),
(8, 5, '7th Symphony');

-- --------------------------------------------------------

--
-- Table structure for table `artist`
--

CREATE TABLE IF NOT EXISTS `artist` (
  `Artist_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Artist_Name` varchar(50) NOT NULL,
  `Image_Location` varchar(100) NOT NULL,
  `Intro` text NOT NULL,
  `Info` text NOT NULL,
  `Genre` varchar(150) NOT NULL,
  PRIMARY KEY (`Artist_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `artist`
--

INSERT INTO `artist` (`Artist_ID`, `Artist_Name`, `Image_Location`, `Intro`, `Info`, `Genre`) VALUES
(1, 'Shinedown', 'images/band_profile/shinedown.jpg', 'Melodic hard rockers Shinedown hail from Jacksonville, Florida and originally featured vocalist Brent Smith, guitarist Jasin Todd, bassist Brad Stewart, and drummer Barry Kerch.', '<p>Snapped up by Atlantic Records during the early-2000s flurry of post-Creed and Nickelback signings, the group released its debut album, Leave a Whisper, in 2003. Whisper ended up doing quite well for the band (eventually going platinum), aided by its single, "Fly from the Inside." Shinedown also supported it with a heroic slate of live shows, remaining on tour for most of 2004. The following year the band issued a live album documenting those shows, then returned in October 2005 with its sophomore effort, Us and Them, which went gold. The band underwent a few lineup changes in the years to follow, re-emerging in 2008 as a quintet that included Smith and Kerch along with guitarists Nick Perri and Zach Myers and bass player Eric Bass.</p>\r\n\r\n<p>The long-awaited Sound of Madness, featuring Grammy-winning producer Rob Cavallo (Goo Goo Dolls, Green Day), arrived in July. In 2009, the band parted ways with Nick Perri and continued on as a quartet. Fitting with its driving sound, the band loaned some of its songs to the WWE to use during their pay-per-view events, as well as a number of other soundtracks, all the while touring for Sound of Madness. All this touring eventually led to a CD/DVD set, 2011''s Somewhere in the Stratosphere , which featured a pair of complete live sets from their Carnival of Madness and Anything & Everything tours. Preceded by the emotionally charged first single "Bully," the band''s fourth studio album, Amaryllis, was released in the spring of 2012. ~ Eduardo Rivadavia</p>', 'Alternative Metal, Hard Rock, Post-grunge,Southern Rock, Heavy Metal'),
(2, 'Stone Sour', 'images/band_profile/stone_sour.jpg', 'Although Slipknot made their mainstream debut in the late ''90s, singer Corey Taylor and guitarist Jim Root got their start a few years prior in Stone Sour.', '<p>Described as a cross between Metallica and Alice in Chains, the group spent several years playing the Iowa bar circuit before the two men joined Slipknot. Stone Sour re-formed in the early 2000s, though, and quickly distinguished themselves with a pair of gold-selling albums and three Grammy nominations.</p>\r\n\r\n<p>The band''s reunion began in early 2002, when Root and Taylor contacted original guitarist Josh Rand and bassist Sean Economaki about recording a full-length Stone Sour album. The bandmates had released several demos during their initial time together, and some of those songs were re-recorded for Stone Sour''s self-titled debut, which earned two Grammy nominations and was RIAA-certified gold. Drafting in drummer Joel Ekman, the band released a song for the Spider-Man soundtrack ("Bother," credited only to Taylor) while recording the album in Los Angeles. A tour followed, and Stone Sour took a short break while Taylor and Root returned their attention to Slipknot for the recording of Vol. 3: The Subliminal Verses.</p>\r\n\r\n<p>Several years later, the band returned to the studio to work on a second album. Come What(ever) May was produced by Nick Raskulinecz (Foo Fighters, Velvet Revolver) and released in August 2006, where it hit number four on the Billboard charts and spawned the successful single "Through Glass." Stone Sour hit the road that same year on the Family Values tour with high-profile headliners Deftones and Korn, and they released a digital concert album, Live in Moscow, in 2007. Once the touring was over, Corey Taylor and Jim Root shifted their focus to Slipknot once again, this time for the creation of 2008''s All Hope Is Gone. Stone Sour''s hiatus was shorter this time around, though, as the band returned in 2010 with a new album, Audio Secrecy. ~ Bradley Torreano</p>', 'Heavy Metal, Post-Grunge, Alternative Metal, Hard Rock'),
(3, 'Slash', 'images/band_profile/slash.jpg', 'As the lead guitarist for Guns N'' Roses, Slash established himself as one of hard rock''s finest and most soulful soloists during the late ''80s, technically adept yet always firmly grounded in the gritty Aerosmith and Stones licks he loved.', '<p>Slash was born Saul Hudson on July 23, 1965, in Stoke-on-Trent, England, to artistic parents both involved in the entertainment industry; his mother was a clothing designer who worked on David Bowie''s film The Man Who Fell to Earth, and his father designed album art for such artists as Neil Young and Joni Mitchell. The family eventually moved to Hollywood, where Hudson attended junior high, received his first guitar, and met future GNR drummer Steven Adler. With Hudson adopting the nickname Slash, given to him by a family friend, the two formed a band called Road Crew; although it proved unsuccessful, it was the vehicle through which they met and eventually joined up with the other members of Guns N'' Roses.</p>\r\n\r\n<p>The Gunners debuted in June 1985, and even before Appetite for Destruction was released in 1987, the bandmembers acquired a reputation as notorious alcohol and drug abusers. As their popularity soared, the reserved Slash established himself as an important part of the band''s visual image, with a top hat and a mound of shaggy black hair covering his face as he typically staggered around the stage with a cigarette dangling from his mouth. Hedonistic excess consumed most of the band, with such incidents as Slash and Duff McKagan''s drunken, profane acceptance of the band''s American Music Award on live television. In 1990, opening for the Rolling Stones, Axl Rose''s infamous on-stage pronouncement that he would leave the band if certain members did not stop "dancing with Mr. Brownstone" (using heroin) was primarily directed at Slash and Adler; Slash kicked his habit within a year, but Adler did not and was fired. In 1992, Slash courted controversy again with a product endorsement for Black Death vodka. Later that year, he was married to actress and model Renee Sorum, a union that lasted five years.</p>\r\n\r\n<p>Rumors about the status of Guns N'' Roses had been swirling for some time, and in October 1996 it was confirmed that, owing to his unwillingness to follow Axl Rose''s interest in industrial and electronic music, Slash was no longer a member of the band (although he left the door open for a reunion if Rose decided to return to guitar-based rock & roll). He gigged off and on with the Blues Ball into 1998, although a rumored live album never materialized. Instead, Slash decided to re-form the Snakepit in 1999 with an entirely different lineup (the original members were by this time involved in other projects, and the Blues Ball was more suited to touring than developing original material). Raspy-voiced singer Rod Jackson and ex-Venice drummer Matt Laug came on board, along with Blues Ball bassist Griparic (now Johnny Blackout) and Teddy Andreadis, who contributed keyboard and harmonica work. After trying out ex-Alice Cooper guitarist Ryan Roxie, Slash settled on rhythm guitarist Kerry Kelly, who had previously worked with Warrant and Ratt.</p>\r\n\r\n<p>The new Snakepit played some gigs together and in the spring of 2000 completed a new album, which was originally slated to be released on Interscope/Geffen. However, feeling that a more traditional guitar rock album would get lost in the promotional shuffle, Slash moved over to Koch, which finally released Ain''t Life Grand in October 2000. A few years later, Slash teamed up again with McKagan, Matt Sorum, and Stone Temple Pilots lead singer Scott Weiland to form the supergroup Velvet Revolver, who released their first album in 2004. Velvet Revolver released a second album called Contraband in 2007 and fell apart not long afterward. Slash regrouped by releasing his memoir in 2007 and cutting his eponymous first solo album, drafting a bunch of friends -- including Ozzy Osbourne, Chris Cornell, Kid Rock, and Fergie -- to sing lead vocals. For the supporting tour, Slash had Alter Bridge vocalist Myles Kennedy sing lead Slash''s second album, 2012''s Apocalyptic Love. ~ Steve Huey</p>', 'Hard Rock, Heavy Metal, Blues Rock'),
(4, 'Flyleaf', 'images/band_profile/flyleaf.jpg', 'The Belton, Texas-based heavy rock quintet Flyleaf formed in 2000 when frontwoman Lacey Mosley played a string of the dark, hard-edged songs she consistently wrote as a brooding teen for drummer James Culpepper.', '<p>After a brief period of playing together, they recruited guitarists Sameer Bhattacharya and Jared Hartmann, members of a local outfit that had recently called it quits. In 2002, bassist Pat Seals joined, and the band, initially known as Passerby, was born.</p>\r\n\r\n<p>The road to Flyleaf''s 2005 self-titled debut on Octone Records was dotted with more green lights than red: the band played wherever it was invited around its home state at first, gradually building the kind of fan base that allowed it to open for acts such as Bowling for Soup, Fishbone, and Riddlin'' Kids. By 2003, with word of Mosley''s arsenic-laced lyrics and blow torch-style delivery spreading through Texas and beyond, Flyleaf earned a spot at the annual South by Southwest music conference. A contract from Octone was rushed to the signing stages by 2004.</p>\r\n\r\n<p>An EP, issued in early 2005 and also called Flyleaf, benefited from the production team of Rick Parashar (Pearl Jam, Blind Melon) and Brad Cook (Foo Fighters, Queens of the Stone Age). Key tracks such as the roiling "Cassie" and the emo-tinged "Breathe Today," both of which appear on the full-length, furthered Flyleaf''s reputation, as did raging live shows alongside Saliva, Breaking Benjamin, 3 Doors Down, and Staind. For the fall 2005 release, producer Howard Benson (My Chemical Romance, Papa Roach, the All-American Rejects) joined Flyleaf in Los Angeles. A batch of 20 songs was winnowed to 12, with Mosley''s searing vocals and Bhattacharya''s and Hartmann''s storming guitars offsetting each other to affect a sound by turns morose, compassionate, hopeful, and bitter.</p>\r\n\r\n<p>Following the release of Flyleaf, the band toured heavily on the festival circuit. They hit the main stage on the 2006 and 2007 Family Values Tour, as well as the Soundwave festival and Disturbed''s Music as a Weapon III Tour. They also made a jump to the world of video games when their single "I''m So Sick" was put in the first installment of the Rock Band series and their new single, "Tina" debuted in Guitar Hero 3. After taking some time out of their hectic touring schedule to record, Flyleaf released their sophomore album, Memento Mori, in 2009. In 2010 Flyleaf delivered the EP Remember to Live, featuring stripped-down, reworked versions of some of the band''s early songs. ~ Tammy La Gorce</p>', 'Alternative Metal, Hard Rock, Post-Grunge'),
(5, 'Apocalyptica', 'images/band_profile/apocalyptica.jpg', 'The Helsinki, Finland quartet Apocalyptica were initially comprised of classically trained cellists Eicca Toppinen, Max Lilja, Antero Manninen, and Paavo Lotjonen; formed in 1993, the group made waves internationally in 1996 with Plays Metallica by Four Cellos, which combined their formal background with their love of heavy metal.', '<p>The album found favor with both classical buffs and metalheads alike, and two years later, Apocalyptica resurfaced with Inquisition Symphony, which featured covers of material by Faith No More and Pantera. Manninen soon left the band and was replaced by Perttu Kivilaanso. They added double bass and percussion to the mix for 2001''s Cult, a collection of all-original material, and again on 2003''s Reflections, which featured guest drummer Dave Lombardo from Slayer. Max Lilja had left the band and Mikko Siren joined as the band''s permanent drummer.</p>\r\n\r\n<p>After Reflections was reissued as Reflections Revised, featuring a bonus track with new wave diva Nina Hagen, 2005 saw the release of the eponymous Apocalyptica, followed in 2006 by the collection Amplified: A Decade of Reinventing the Cello. The band returned to the studio the following year for Worlds Collide. Rammstein vocalist Till Lindemann appeared on the album performing a German-language version of David Bowie''s "Helden." Apocalyptica issued their obligatory Live album in 2008, and followed it with the adventurous 7th Symphony in 2010, with guest appearances by ex-Bush frontman Gavin Rossdale, Brent Smith from Shinedown, Slayer''s Dave Lombardo, Lacey Mosley of Flyleaf, and Joe Duplantier of Gorija. ~ Jason Ankeny</p>', 'Cello Metal, Neo-Classical Metal, Progressive Metal, Symphonic Metal, Classical Music');

-- --------------------------------------------------------

--
-- Table structure for table `artistfavorited`
--

CREATE TABLE IF NOT EXISTS `artistfavorited` (
  `Artist_ID` int(11) NOT NULL,
  `User_ID` int(11) NOT NULL,
  PRIMARY KEY (`Artist_ID`,`User_ID`),
  KEY `User_ID` (`User_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `artistfavorited`
--

INSERT INTO `artistfavorited` (`Artist_ID`, `User_ID`) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 2),
(4, 3),
(5, 3),
(1, 4),
(3, 4),
(1, 5),
(5, 5);

-- --------------------------------------------------------

--
-- Table structure for table `song`
--

CREATE TABLE IF NOT EXISTS `song` (
  `Song_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Album_ID` int(11) NOT NULL,
  `Song_Name` varchar(50) NOT NULL,
  `Duration` varchar(5) NOT NULL,
  `Date_Added` date NOT NULL,
  `Song_Location` varchar(100) NOT NULL,
  PRIMARY KEY (`Song_ID`),
  KEY `Album_ID` (`Album_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=103 ;

--
-- Dumping data for table `song`
--

INSERT INTO `song` (`Song_ID`, `Album_ID`, `Song_Name`, `Duration`, `Date_Added`, `Song_Location`) VALUES
(1, 1, 'Fly From the Inside', '03:55', '2013-01-01', 'songs/shinedown/Leave A Whisper/01 Fly From the Inside.mp3'),
(2, 1, 'Left Out', '03:53', '2013-01-01', 'songs/shinedown/Leave A Whisper/02 Left Out.mp3'),
(3, 1, 'Lost in the Crowd', '03:56', '2013-01-01', 'songs/shinedown/Leave A Whisper/03 Lost in the Crowd.mp3'),
(4, 1, 'No More Love', '03:46', '2013-01-01', 'songs/shinedown/Leave A Whisper/04 No More Love.mp3'),
(5, 1, 'Better Version', '03:46', '2013-01-01', 'songs/shinedown/Leave A Whisper/05 Better Version.mp3'),
(6, 1, 'Burning Bright', '03:47', '2013-01-01', 'songs/shinedown/Leave A Whisper/06 Burning Bright.mp3'),
(7, 1, 'In Memory', '04:06', '2013-01-01', 'songs/shinedown/Leave A Whisper/07 In Memory.mp3'),
(8, 1, 'All I Ever Wanted', '04:10', '2013-01-01', 'songs/shinedown/Leave A Whisper/08 All I Ever Wanted.mp3'),
(9, 1, 'Stranger Inside', '04:06', '2013-01-01', 'songs/shinedown/Leave A Whisper/09 Stranger Inside.mp3'),
(10, 1, 'Lacerated', '03:58', '2013-01-01', 'songs/shinedown/Leave A Whisper/10 Lacerated.mp3'),
(11, 1, 'Crying Out', '03:31', '2013-01-01', 'songs/shinedown/Leave A Whisper/11 Crying Out.mp3'),
(12, 1, '45', '04:14', '2013-01-01', 'songs/shinedown/Leave A Whisper/12 45.mp3'),
(13, 1, 'Simple Man', '05:21', '2013-01-01', 'songs/shinedown/Leave A Whisper/13 Simple Man.mp3'),
(14, 2, 'The Dream', '00:59', '2013-01-08', 'songs/shinedown/Us And Them/01 The Dream.mp3'),
(15, 2, 'Heroes', '03:24', '2013-01-08', 'songs/shinedown/Us And Them/02 Heros.mp3'),
(16, 2, 'Save Me', '03:33', '2013-01-08', 'songs/shinedown/Us And Them/03 Save Me.mp3'),
(17, 2, 'I Dare You', '03:54', '2013-01-08', 'songs/shinedown/Us And Them/04 I Dare You.mp3'),
(18, 2, 'Yer Majesty', '03:01', '2013-01-08', 'songs/shinedown/Us And Them/05 Yer Majesty.mp3'),
(19, 2, 'Beyond The Sun', '04:13', '2013-01-08', 'songs/shinedown/Us And Them/06 Beyond The Sun.mp3'),
(20, 2, 'Trade Yourself In', '03:32', '2013-01-08', 'songs/shinedown/Us And Them/07 Trade Yourself In.mp3'),
(21, 2, 'Lady So Divine', '07:09', '2013-01-08', 'songs/shinedown/Us And Them/08 Lady So Divine.mp3'),
(22, 2, 'Shed Some Light', '03:41', '2013-01-08', 'songs/shinedown/Us And Them/09 Shed Some Light.mp3'),
(23, 2, 'Begin Again', '03:49', '2013-01-08', 'songs/shinedown/Us And Them/10 Begin Again.mp3'),
(24, 2, 'Atmosphere', '04:16', '2013-01-08', 'songs/shinedown/Us And Them/11 Atmosphere.mp3'),
(25, 2, 'Fake', '04:04', '2013-01-08', 'songs/shinedown/Us And Them/12 Fake.mp3'),
(26, 2, 'Some Day', '03:14', '2013-01-08', 'songs/shinedown/Us And Them/13 Some Day.mp3'),
(27, 3, 'Devour', '03:50', '2013-01-15', 'songs/shinedown/The Sound of Madness/01 Devour.mp3'),
(28, 3, 'Sound of Madness', '03:54', '2013-01-15', 'songs/shinedown/The Sound of Madness/02 Sound of Madness.mp3'),
(29, 3, 'Second Chance', '03:40', '2013-01-15', 'songs/shinedown/The Sound of Madness/03 Second Chance.mp3'),
(30, 3, 'Cry for Help', '03:20', '2013-01-15', 'songs/shinedown/The Sound of Madness/04 Cry for Help.mp3'),
(31, 3, 'The Crow & The Butterfly', '04:13', '2013-01-15', 'songs/shinedown/The Sound of Madness/05 The Crow & The Butterfly.mp3'),
(32, 3, 'If You Only Knew', '03:56', '2013-01-15', 'songs/shinedown/The Sound of Madness/06 If You Only Knew.mp3'),
(33, 3, 'Sin with a Grin', '04:00', '2013-01-15', 'songs/shinedown/The Sound of Madness/07 Sin with a Grin.mp3'),
(34, 3, 'What a Shame', '04:19', '2013-01-15', 'songs/shinedown/The Sound of Madness/08 What a Shame.mp3'),
(35, 3, 'Cyanide Sweet Tooth Suicide', '03:11', '2013-01-15', 'songs/shinedown/The Sound of Madness/09 Cyanide Sweet Tooth Suicide.mp3'),
(36, 3, 'Breaking Inside', '03:51', '2013-01-15', 'songs/shinedown/The Sound of Madness/10 Breaking Inside.mp3'),
(37, 3, 'Call Me', '03:42', '2013-01-15', 'songs/shinedown/The Sound of Madness/11 Call Me.mp3'),
(38, 3, 'Energy', '03:24', '2013-01-15', 'songs/shinedown/The Sound of Madness/12 Energy.mp3'),
(39, 3, 'I Own You', '03:37', '2013-01-15', 'songs/shinedown/The Sound of Madness/13 I Own You.mp3'),
(40, 3, 'Son of Sam', '03:37', '2013-01-15', 'songs/shinedown/The Sound of Madness/14 Son of Sam.mp3'),
(41, 3, 'Junkies For Fame', '03:27', '2013-01-15', 'songs/shinedown/The Sound of Madness/15 Junkies For Fame.mp3'),
(42, 4, 'Adrenaline', '03:50', '2013-01-22', 'songs/shinedown/Amaryllis/01 Devour.mp3'),
(43, 4, 'Bully', '03:54', '2013-01-22', 'songs/shinedown/Amaryllis/02 Bully.mp3'),
(44, 4, 'Amaryllis', '03:40', '2013-01-22', 'songs/shinedown/Amaryllis/03 Amaryllis.mp3'),
(45, 4, 'Unity', '03:20', '2013-01-22', 'songs/shinedown/Amaryllis/04 Unity.mp3'),
(46, 4, 'Enemies', '04:13', '2013-01-22', 'songs/shinedown/Amaryllis/05 Enemies.mp3'),
(47, 4, 'I''m Not Alright', '03:56', '2013-01-22', 'songs/shinedown/Amaryllis/06 I''m Not Alright.mp3'),
(48, 4, 'Nowhere Kids', '04:00', '2013-01-22', 'songs/shinedown/Amaryllis/07 Nowhere Kids.mp3'),
(49, 4, 'Miracle', '04:19', '2013-01-22', 'songs/shinedown/Amaryllis/08 Miracle.mp3'),
(50, 4, 'I''ll Follow You', '03:11', '2013-01-22', 'songs/shinedown/Amaryllis/09 I''ll Follow You.mp3'),
(51, 4, 'For My Sake', '03:51', '2013-01-22', 'songs/shinedown/Amaryllis/10 For My Sake.mp3'),
(52, 4, 'My Name (Wearing Me Out)', '03:42', '2013-01-22', 'songs/shinedown/Amaryllis/11 My Name (Wearing Me Out).mp3'),
(53, 4, 'Through the Ghost', '03:24', '2013-01-22', 'songs/shinedown/Amaryllis/12 Through the Ghost.mp3'),
(54, 5, 'Gone Sovereign', '04:03', '2013-02-01', 'songs/stone_sour/House Of Gold And Bones/Gone Sovereign.mp3'),
(55, 5, 'Absolute Zero', '03:49', '2013-02-01', 'songs/stone_sour/House Of Gold And Bones/Absolute Zero.mp3'),
(56, 5, 'A Rumor Of Skin', '04:11', '2013-02-01', 'songs/stone_sour/House Of Gold And Bones/A Rumor Of Skin.mp3'),
(57, 5, 'The Travelers Part 1', '02:26', '2013-02-01', 'songs/stone_sour/House Of Gold And Bones/The Travelers Part 1.mp3'),
(58, 5, 'Tired', '04:11', '2013-02-01', 'songs/stone_sour/House Of Gold And Bones/Tired.mp3'),
(59, 5, 'Ru', '4:22', '2013-02-01', 'songs/stone_sour/House Of Gold And Bones/Ru.mp3'),
(60, 5, 'My Name Is Allen', '04:18', '2013-02-01', 'songs/stone_sour/House Of Gold And Bones/My Name Is Allen.mp3'),
(61, 5, 'Taciturn', '05:25', '2013-02-01', 'songs/stone_sour/House Of Gold And Bones/Taciturn.mp3'),
(62, 5, 'Influence Of Drowsy God', '04:29', '2013-02-01', 'songs/stone_sour/House Of Gold And Bones/Influence Of Drowsy God.mp3'),
(63, 5, 'The Traverler Part 2', '03:01', '2013-02-01', 'songs/stone_sour/House Of Gold And Bones/The Traverler Part 2.mp3'),
(64, 5, 'Last Of The Real', '03:01', '2013-02-01', 'songs/stone_sour/House Of Gold And Bones/Last Of The Real.mp3'),
(65, 8, 'At the Gates of Manala', '07:01', '2013-02-08', 'songs/apocalyptica/7th Symphony/At the Gates of Manala.mp3'),
(66, 8, 'End Of Me', '03:26', '2013-02-08', 'songs/apocalyptica/7th Symphony/End Of Me.mp3'),
(67, 8, 'Not Strong Enough', '03:34', '2013-02-08', 'songs/apocalyptica/7th Symphony/Not Strong Enough.mp3'),
(68, 8, '2010', '04:28', '2013-02-08', 'songs/apocalyptica/7th Symphony/2010.mp3'),
(69, 8, 'Through Paris in a Sportscar', '03:50', '2013-02-08', 'songs/apocalyptica/7th Symphony/Through Paris in a Sportscar.mp3'),
(70, 8, 'Beautiful', '02:16', '2013-02-08', 'songs/apocalyptica/7th Symphony/Beautiful.mp3'),
(71, 8, 'Broken Pieces', '03:52', '2013-02-08', 'songs/apocalyptica/7th Symphony/Broken Pieces.mp3'),
(72, 8, 'On the Rooftop with Quasimodo', '04:57', '2013-02-08', 'songs/apocalyptica/7th Symphony/On the Rooftop with Quasimodo.mp3'),
(73, 8, 'Bring Them To Light', '04:42', '2013-02-08', 'songs/apocalyptica/7th Symphony/Bring Them To Light.mp3'),
(74, 8, 'Sacra', '04:20', '2013-02-08', 'songs/apocalyptica/7th Symphony/Sacra.mp3'),
(75, 8, 'Rage of Poseidon', '08:39', '2013-02-08', 'songs/apocalyptica/7th Symphony/Rage of Poseidon.mp3'),
(76, 8, 'The Shadow of Venus', '06:04', '2013-02-08', 'songs/apocalyptica/7th Symphony/The Shadow of Venus.mp3'),
(77, 7, 'Fire Fire', '03:02', '2013-02-15', 'songs/flyleaf/New Horizons/Fire Fire.mp3'),
(78, 7, 'New Horizons', '03:09', '2013-02-15', 'songs/flyleaf/New Horizons/New Horizons.mp3'),
(79, 7, 'Call You Out', '02:20', '2013-02-08', 'songs/flyleaf/New Horizons/Call You Out.mp3'),
(80, 7, 'Cage On The Ground', '03:34', '2013-02-08', 'songs/flyleaf/New Horizons/Cage On The Ground.mp3'),
(81, 7, 'Great Love', '03:42', '2013-02-08', 'songs/flyleaf/New Horizons/Great Love.mp3'),
(82, 7, 'Bury Your Heart', '03:35', '2013-02-08', 'songs/flyleaf/New Horizons/Bury Your Heart.mp3'),
(83, 7, 'Freedom', '03:20', '2013-02-08', 'songs/flyleaf/New Horizons/Freedom.mp3'),
(84, 7, 'Saving Grace', '03:44', '2013-02-08', 'songs/flyleaf/New Horizons/Saving Grace.mp3'),
(85, 7, 'Stand', '03:40', '2013-02-08', 'songs/flyleaf/New Horizons/Stand.mp3'),
(86, 7, 'Green Heart', '02:44', '2013-02-08', 'songs/flyleaf/New Horizons/Green Heart.mp3'),
(87, 7, 'Broken Wings', '03:34', '2013-02-08', 'songs/flyleaf/New Horizons/Broken Wings.mp3'),
(88, 6, 'Apocalyptic Love', '03:28', '2013-02-15', 'songs/slash/Apocalyptic Love/Apocalyptic Love.mp3'),
(89, 6, 'One Last Thrill', '03:09', '2013-02-15', 'songs/slash/Apocalyptic Love/One Last Thrill.mp3'),
(90, 6, 'Standing In The Sun', '04:03', '2013-02-15', 'songs/slash/Apocalyptic Love/Standing In The Sun.mp3'),
(91, 6, 'You''re A Lie', '03:50', '2013-02-15', 'songs/slash/Apocalyptic Love/You''re A Lie.mp3'),
(92, 6, 'No More Heroes', '04:23', '2013-02-15', 'songs/slash/Apocalyptic Love/No More Heroes.mp3'),
(93, 6, 'Halo', '03:22', '2013-02-15', 'songs/slash/Apocalyptic Love/Halo.mp3'),
(94, 6, 'We Will Roam', '04:49', '2013-02-15', 'songs/slash/Apocalyptic Love/We Will Roam.mp3'),
(95, 6, 'Anastasia', '06:07', '2013-02-15', 'songs/slash/Apocalyptic Love/Anastasia.mp3'),
(96, 6, 'Not For Me', '05:21', '2013-02-15', 'songs/slash/Apocalyptic Love/Not For Me.mp3'),
(97, 6, 'Bad Rain', '03:46', '2013-02-15', 'songs/slash/Apocalyptic Love/Bad Rain.mp3'),
(98, 6, 'Hard & Fast', '03:02', '2013-02-15', 'songs/slash/Apocalyptic Love/Hard & Fast.mp3'),
(99, 6, 'Far And Away', '05:14', '2013-02-15', 'songs/slash/Apocalyptic Love/Far And Away.mp3'),
(100, 6, 'Shots Fired', '03:48', '2013-02-15', 'songs/slash/Apocalyptic Love/Shots Fired.mp3'),
(101, 6, 'Carolina', '03:17', '2013-02-15', 'songs/slash/Apocalyptic Love/Carolina.mp3'),
(102, 6, 'Crazy Life', '03:40', '2013-02-15', 'songs/slash/Apocalyptic Love/Crazy Life.mp3');

-- --------------------------------------------------------

--
-- Table structure for table `songfavorited`
--

CREATE TABLE IF NOT EXISTS `songfavorited` (
  `Song_ID` int(11) NOT NULL,
  `User_ID` int(11) NOT NULL,
  PRIMARY KEY (`Song_ID`,`User_ID`),
  KEY `User_ID` (`User_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `songfavorited`
--

INSERT INTO `songfavorited` (`Song_ID`, `User_ID`) VALUES
(12, 1),
(67, 1),
(68, 1),
(88, 1),
(54, 2),
(65, 2),
(67, 2),
(69, 2),
(16, 3),
(67, 3),
(77, 3),
(55, 4),
(89, 4),
(66, 5),
(88, 5);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `User_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(20) NOT NULL,
  `Password` varchar(32) NOT NULL,
  `Email_Address` varchar(30) NOT NULL,
  PRIMARY KEY (`User_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`User_ID`, `Username`, `Password`, `Email_Address`) VALUES
(1, 'David', '5f4dcc3b5aa765d61d8327deb882cf99', 'david2.norton@live.uwe.ac.uk'),
(2, 'Chris', '5f4dcc3b5aa765d61d8327deb882cf99', 'chris2.rollin@live.uwe.ac.uk'),
(3, 'Greg', '5f4dcc3b5aa765d61d8327deb882cf99', 'greg2.huntley@live.uwe.ac.uk'),
(4, 'Hiten', '5f4dcc3b5aa765d61d8327deb882cf99', 'hiten2.kotecha@live.uwe.ac.uk'),
(5, 'Tutor', '5f4dcc3b5aa765d61d8327deb882cf99', 'Tutor@uwe.ac.uk');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `album`
--
ALTER TABLE `album`
  ADD CONSTRAINT `album_ibfk_1` FOREIGN KEY (`Artist_ID`) REFERENCES `artist` (`Artist_ID`);

--
-- Constraints for table `artistfavorited`
--
ALTER TABLE `artistfavorited`
  ADD CONSTRAINT `artistfavorited_ibfk_1` FOREIGN KEY (`Artist_ID`) REFERENCES `artist` (`Artist_ID`),
  ADD CONSTRAINT `artistfavorited_ibfk_2` FOREIGN KEY (`User_ID`) REFERENCES `user` (`User_ID`);

--
-- Constraints for table `song`
--
ALTER TABLE `song`
  ADD CONSTRAINT `song_ibfk_1` FOREIGN KEY (`Album_ID`) REFERENCES `album` (`Album_ID`);

--
-- Constraints for table `songfavorited`
--
ALTER TABLE `songfavorited`
  ADD CONSTRAINT `songfavorited_ibfk_1` FOREIGN KEY (`Song_ID`) REFERENCES `song` (`Song_ID`),
  ADD CONSTRAINT `songfavorited_ibfk_2` FOREIGN KEY (`User_ID`) REFERENCES `user` (`User_ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
