package hk.edu.polyu.comp.comp2021.g17.cvfs.model.filesystem;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import hk.edu.polyu.comp.comp2021.g17.cvfs.model.exception.FileAlreadyExistException;
import hk.edu.polyu.comp.comp2021.g17.cvfs.model.exception.FileNotExistException;
import hk.edu.polyu.comp.comp2021.g17.cvfs.model.exception.InvalidArgumentException;
import hk.edu.polyu.comp.comp2021.g17.cvfs.model.exception.InvalidFileNameException;
import hk.edu.polyu.comp.comp2021.g17.cvfs.model.exception.UsageException;

class FileSystemTest {
	
	FileSystem fileSystem;
	
	FileSystemTest(){
		fileSystem = new FileSystem("test");
	}

	@Test
	void loadStoreTest() {
		try {
			String pathLoad = "C:\\toLoad"; //directory on your disk
			String pathStore = "C:\\toStore"; //directory on your disk
			fileSystem.newDisk("100000");
			fileSystem.load(pathLoad);
			fileSystem.rList("");
			fileSystem.store(pathStore);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void undoRedoTest() {
		try {
			fileSystem.newDisk("10000");
			fileSystem.commandHistory.add(++fileSystem.commandPtr,"newDisk 10000");
			fileSystem.newDir("dir1");
			fileSystem.commandHistory.add(++fileSystem.commandPtr,"newDir dir1");
			fileSystem.newDoc("abc txt \"haha\"");
			fileSystem.commandHistory.add(++fileSystem.commandPtr,"newDoc abc txt \"haha\"");
			fileSystem.list("");
			fileSystem.undo("");
			fileSystem.list("");
			fileSystem.redo("");
			fileSystem.list("");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
