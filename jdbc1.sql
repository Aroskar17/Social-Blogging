

CREATE TABLE `blog` (
  `userId` int(3) DEFAULT NULL,
  `blogId` int(3) NOT NULL,
  `title` varchar(40) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `blog`
--

INSERT INTO `blog` (`userId`, `blogId`, `title`, `content`) VALUES
(189, 200, 'first blog', 'my first blog'),
(189, 201, 'first blog', 'my first blog'),
(189, 202, 'first blog', 'my first blog'),
(189, 203, 'first blog', 'my first blog'),
(189, 204, 'first blog', 'my first blog'),
(189, 205, 'Anmay', 'comp');

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `userId` int(3) DEFAULT NULL,
  `cid` int(3) NOT NULL,
  `blogId` int(3) DEFAULT NULL,
  `message` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`userId`, `cid`, `blogId`, `message`) VALUES
(189, 500, 200, 'Nice Blog'),
(189, 501, 200, 'rouhioruthiur');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userId` int(3) NOT NULL,
  `email` varchar(30) NOT NULL,
  `pw` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `admin` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userId`, `email`, `pw`, `username`, `admin`) VALUES
(189, 'Amit@gmail.com', '123', 'Amit', 'false'),
(800, 'ad@gmail.com', '123', 'ad', 'true');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `blog`
--
ALTER TABLE `blog`
  ADD PRIMARY KEY (`blogId`);

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`cid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
