package com.icss.commons;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import javax.imageio.ImageIO;


import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 鏂囦欢鍜屾祦鐨勫熀鏈搷浣�
 * @author zhoujl
 *
 */

@SuppressWarnings("restriction")
public final class FileUtil {

	private static FileUtil fileUtil;
	private FileUtil(){}
	
	
	public static FileUtil newInstance(){
		if(fileUtil == null)
		{
			fileUtil = new FileUtil();
		}
		
		return fileUtil;
	}
	

	/**
	 * 灏嗚緭鍏ユ祦in淇濆瓨鍒版枃浠秄ileName
	 * @param in
	 * @param fileName 瀹屽叏鏂囦欢鍚�
	 * @return
	 */
	public void saveFile(InputStream in,java.io.File file)throws Exception
	{
		OutputStream out=new FileOutputStream(file);
		byte[] buffer = new byte[1024];
		int bytesRead = 0;
		while ((bytesRead = in.read(buffer, 0, 1024)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
        out.close();
        in.close();
	}
	
	/**
	 * 鑾峰彇鏂囦欢鍚嶇О锛屽幓璺緞鍜屾墿灞曞悕
	 * @param a
	 * @return
	 */
	public Object getFileName(String fileName)
	{
		try
		{
			if(fileName.lastIndexOf("/")>0)
			{
				return fileName.substring(fileName.lastIndexOf("/")+1,fileName.lastIndexOf("."));
			}else
			{
				return fileName.substring(0,fileName.lastIndexOf("."));
			}
		}catch(Exception ex)
		{
			return fileName;
		}
	}
	
	/**
	 * 鑾峰彇鏂囦欢澶у皬鎻忓彊
	 * @param size
	 * @return
	 */
	public String getSizeDescribe(long size)
	{
		try
		{
			if(size < 1024) {
				return size + " bytes";
			} else if(size < 1048576) {
				return (Math.round(((size*10) / 1024))/10) + " KB";
			} else {
				return (Math.round(((size*10) / 1048576))/10) + " MB";
			}
		}catch(Exception ex)
		{
			return Long.toString(size);
		}
	}
	
	/**
	 * 鑾峰彇鏂囦欢鎵╁睍鍚�
	 * @param fileName
	 * @return
	 */
	public String getFileExt(String fileName)
	{
		try
		{
			return fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
		}catch(Exception ex)
		{
			return "unknow";
		}
	}
	
	/**
	 * 鏂囦欢鎷疯礉
	 * @param fileFrom 鍘熸枃浠�
	 * @param fileTo 鎷疯礉鍚庣殑鏂囦欢
	 
	 */
    public void copy(File fileFrom, File fileTo) throws Exception {   
          
            FileInputStream in = new java.io.FileInputStream(fileFrom);   
            FileOutputStream out = new FileOutputStream(fileTo);   
            byte[] bt = new byte[1024];   
            int count;   
            while ((count = in.read(bt)) > 0) {   
                out.write(bt, 0, count);   
            }   
            in.close();   
            out.close();   
           
    }
	
    public void  delete(File file) throws Exception
    {
    	
    		file.delete();
    
    }
	
	
	/**
	 * 淇濆瓨瀵硅薄鍒癴ileName鐨勬枃浠�
	 * @param fileName
	 * @param obj
	 * @return
	 */
	public boolean saveObject(File file,Object obj)
	{
		try{
			FileOutputStream fo=new FileOutputStream(file);
			ZipOutputStream out = new ZipOutputStream(fo);
			ZipEntry entry = new ZipEntry("data");
			out.putNextEntry(entry);
			ObjectOutputStream so=new ObjectOutputStream(out);
			so.writeObject(obj); 
			so.close();
			out.close();
			fo.close();
		}catch(IOException e) 
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 浠巉ileName瀵瑰簲鐨勬枃浠朵腑璇诲彇瀵硅薄
	 * @param fileName
	 * @return
	 */
	public Object readObject(File file)
	{
		Object obj=null;
		try{
			
			ZipFile zipFile = new ZipFile(file);
			ZipEntry entry = zipFile.getEntry("data");
			ObjectInputStream si=new ObjectInputStream(zipFile.getInputStream(entry));
			obj=si.readObject();
			si.close();
			zipFile.close();
		}catch(Exception e)
		{
			obj=null;
		}
		return obj;

	}
	
	/**
	 * 璇诲彇鏂囨湰鏂囦欢锛岀紪鐮乁TF-8
	 * @param file
	 * @return
	 */
	public String readText(File file){
		return readText(file,"UTF-8");
	}
	/**
	 * 璇诲彇鏂囨湰鏂囦欢
	 * @param file
	 * @param charset
	 * @return
	 */
	public String readText(File file,String charset){
		BufferedReader reader = null;
		try{
			FileInputStream fis = new FileInputStream(file);
			DataInputStream in = new DataInputStream(fis);
			reader = new BufferedReader(new InputStreamReader(in, charset));
			StringBuffer text = new StringBuffer();
			String tempString = null;
			while ((tempString = reader.readLine()) != null){
				text.append(tempString);
				text.append("\r\n");
			}
			reader.close();
			in.close();
			fis.close();
			return text.toString();
		}catch(Exception ex){
			return null;
		}
	}
	/**
	 * 淇濆瓨鏂囨湰鏂囦欢锛岀紪鐮乁TF-8
	 * @param content
	 * @param file
	 * @return
	 */
	public boolean saveText(String content,File file){
		return saveText(content, file, "UTF-8");
	}
	/**
	 * 淇濆瓨鏂囨湰鏂囦欢
	 * @param content
	 * @param file
	 * @param charset
	 * @return
	 */
	public boolean saveText(String content,File file,String charset){
		try{
			FileOutputStream fos = new FileOutputStream(file);
			Writer out = new OutputStreamWriter(fos, charset);
			out.write(content);
			out.close();
			fos.close();
		}catch(Exception ex){
			return false;
		}
		return true;

	}

	/**
	 * 淇濆瓨鍥剧墖
	 * @param in銆�枃浠舵祦
	 * @param fileName銆�繚瀛樻枃浠�
	 * @param w銆��鐢ㄩ珮
	 * @param h銆��鐢ㄥ
	 * @param auto銆�皬鍥剧墖鏄惁鏀惧ぇ
	 * @param zip銆�浘鏍峰帇缂╂瘮
	 * @return銆�浘鐗囧瓨鏀惧湴鍧�
	 */
	public void saveImg(InputStream in,java.io.File fileName,int w,int h,boolean auto,float zip)throws Exception
	{
				Image src= ImageIO.read(in);
				int oldW=src.getWidth(null);
				int oldH=src.getHeight(null);
				int newW,newH;
				if(w>oldW&&h>oldH&&auto==false)
				{
					newW=oldW;
					newH=oldH;
				}else
				{
					if(w*oldH>h*oldW)
					{
						newH=h;
						newW=(newH*oldW)/oldH;
					}else
					{
						newW=w;
						newH=(newW*oldH)/oldW;
					}
				}
				BufferedImage tempimg = new BufferedImage(newW, newH, 1);
				tempimg.getGraphics().setColor(new Color(255, 255, 255));
				tempimg.getGraphics().fillRect(0, 0, newW, newH);
				tempimg.getGraphics().drawImage(src, 0, 0, newW, newH, null);
				FileOutputStream tempFile = new FileOutputStream(fileName);
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(tempFile);
				
				JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(tempimg);
				param.setQuality(zip, true);
				encoder.setJPEGEncodeParam(param);
				   
				   
				encoder.encode(tempimg);
				tempFile.close();
				
		
	}
	
	

	/**
	 * 淇濆瓨鍥剧墖
	 * @param in銆�枃浠舵祦
	 * @param fileName銆�繚瀛樻枃浠跺寘鍚矾寰勫悕
	 * @param s銆�按鍗板浘鐗囧湴鍧�
	 * @param w銆��鐢ㄥ
	 * @param h銆��鐢ㄩ珮
	 * @param auto銆�皬鍥剧墖鏄惁鑷姩鏀惧ぇ
	 * @param zip銆�浘鐗囧帇缂╂瘮
	 * @param address銆�按鍗颁綅缃�0涓�1銆�乏涓娿�2銆�彸涓娿�3銆�乏涓嬨�4銆�彸涓�
	 * @return 鏄惁淇濆瓨鎴愬姛
	 */
	public void saveImg(InputStream in,java.io.File fileName,java.io.File sy,int w,int h,boolean auto,float zip,int address)throws Exception
	{
		
			
				Image src= ImageIO.read(in);
				int oldW=src.getWidth(null);
				int oldH=src.getHeight(null);
				int newW,newH;
				if(w>oldW&&h>oldH&&auto==false)
				{
					newW=oldW;
					newH=oldH;
				}else
				{
					if(w*oldH>h*oldW)
					{
						newH=h;
						newW=(newH*oldW)/oldH;
					}else
					{
						newW=w;
						newH=(newW*oldH)/oldW;
					}
				}
				BufferedImage tempimg = new BufferedImage(newW, newH, 1);
				Image syImg=ImageIO.read(sy);
				tempimg.getGraphics().setColor(new Color(255, 255, 255));
				tempimg.getGraphics().fillRect(0, 0, newW, newH);
				tempimg.getGraphics().drawImage(src, 0, 0, newW, newH, null);
				if(newW>syImg.getWidth(null)&&newH>syImg.getHeight(null))
				{
					int tempx=0;
					int tempy=0;
					if(address>4||address<0)
					{
						address=4;
					}
					if(address==0)
					{
						tempx=((newW-syImg.getWidth(null))/2);
						tempy=((newH-syImg.getHeight(null))/2);
					}else if(address==2)
					{
						tempx=newW-syImg.getWidth(null);
					}else if(address==3)
					{
						tempy=newH-syImg.getHeight(null);
					}else if(address==4)
					{
						tempx=newW-syImg.getWidth(null);
						tempy=newH-syImg.getHeight(null);
					}
			
					tempimg.getGraphics().drawImage(syImg, tempx, tempy, syImg.getWidth(null), syImg.getHeight(null), null);
				}
				FileOutputStream tempFile = new FileOutputStream(fileName);
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(tempFile);
				
				JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(tempimg);
				param.setQuality(zip, true);
				encoder.setJPEGEncodeParam(param);
				
				encoder.encode(tempimg);
				tempFile.close();
			
	}

	/**
	 * 
	 * @param out 杈撳嚭鏂囦欢
	 * @param width
	 * @param height
	 * @param bmp
	 * @throws Exception
	 */
	public void saveBMP(OutputStream out,int width,int height,String bmp)throws Exception{
		BufferedImage image = new BufferedImage(width, height, 1);
        Graphics g = image.getGraphics();
        String[] cs = bmp.split(",");
        for(int h=0;h<height;h++){
            for(int w=0;w<width;w++){
        		g.setColor(new Color(Integer.parseInt(cs[h*width+w], 16)));
                g.fillRect(w, h, 1, 1);
        	}
        }
        
        ImageIO.write(image, "jpeg", out);
	}
    
}
