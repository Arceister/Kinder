from io import BytesIO
from PIL import Image, ImageOps
import numpy as np
import tensorflow as tf

def api_hit_response():
  return {"Message": "API Accessed!"}

def predict_image(image_to_predict):
  model = tf.keras.models.load_model('Models/keras_model.h5')
  data = np.ndarray(shape=(1, 224, 224, 3), dtype=np.float32)
  image = Image.open(BytesIO(image_to_predict))
  size = (224, 224)
  image = ImageOps.fit(image, size, Image.ANTIALIAS)

  image_array = np.asarray(image)
  normalized_image_array = (image_array.astype(np.float32) / 127.0) - 1
  data[0] = normalized_image_array

  prediction = model.predict(data)
  pr = np.argmax(prediction, axis=1)

  labels = {
    0: {
      "Hasil": "Apple",
      "Kandungan": {
        "Air": 81.2,
        "Protein": 0.3,
        "Karbohidrat": 14.9,
        "Serat": 2.6,
        "Lain-lain": 1
      },
      "Tidak": ["Lambung", "Wasir", "Ambeien"],
      "Manfaat": ["Jantung", "Diabetes", "Obesitas", "Pencernaan"]
    },
    1: {
      "Hasil": "Orange",
      "Kandungan": {
        "Air": 84.5,
        "Protein": 0.9,
        "Karbohidrat": 11.2,
        "Serat": 2.4,
        "Lain-lain": 1
      },
      "Tidak": ["Lambung", "Wasir", "Ambeien"],
      "Manfaat": ["Janin", "Kulit", "Diabetes", "Pencernaan"]
    },
    2: {
      "Hasil": "Banana",
      "Kandungan": {
        "Air": 67.7,
        "Protein": 1.3,
        "Karbohidrat": 27,
        "Serat": 3,
        "Lain-lain": 1
      },
      "Tidak": ["Asma", "Sembelit", "Diabetes"],
      "Manfaat": ["Janin", "Kulit", "Diabetes", "Pencernaan"]
    },
    3: "Rotten Apple",
    4: "Rotten Orange",
    5: "Rotten Banana"
  }

  return {"Hasil": labels[int(pr[0])]}