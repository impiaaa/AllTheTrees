from PIL import Image
import glob

for fname in glob.glob("leaves_*_fancy.png"):
    im = Image.open(fname)
    color = [0,0,0]
    count = 0
    for x in range(im.size[0]):
        for y in range(im.size[1]):
            px = im.getpixel((x,y))
            if px[3] > 250:
                if sum(px[:3]) > sum(color):
                    for i in range(3):
                        color[i] = px[i]
                    count += 1
    print("%s: 0x%02X%02X%02X"%(fname, color[0], color[1], color[2]))
