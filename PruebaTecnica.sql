USE [PruebaTecnica]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[file_table](
	[file_id] [bigint] IDENTITY(1,1) NOT NULL,
	[name_col] [varchar](255) NOT NULL,
	[name_file] [varchar](255) NOT NULL,
	[total_col] [int] NOT NULL,
	[total_registers] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[file_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[register_table](
	[register_id] [bigint] IDENTITY(1,1) NOT NULL,
	[registro_data] [varchar](255) NOT NULL,
	[file_id_fk] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[register_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[register_table]  WITH CHECK ADD  CONSTRAINT [FKsq6n8g6nio1c5piecpcufvjcv] FOREIGN KEY([file_id_fk])
REFERENCES [dbo].[file_table] ([file_id])
GO
ALTER TABLE [dbo].[register_table] CHECK CONSTRAINT [FKsq6n8g6nio1c5piecpcufvjcv]
GO
