from fastapi import APIRouter, File
from Controllers import controller

router = APIRouter()

@router.get("/")
async def hit_api():
  return controller.api_hit_response()

@router.post("/predict")
def predict(image: bytes = File(...)):
  return controller.predict_image(image)