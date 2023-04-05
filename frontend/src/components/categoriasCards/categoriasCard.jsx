import { useEffect } from 'react'
import { useState } from 'react'
import './categoriasCard.css'
import api from '../../services/api'


function CategoriasCard({filtro}) {

  const url = "https://carlux-grupo1.s3.us-east-2.amazonaws.com";
  const [listCategorys, setListCategorys] = useState([])
  
  useEffect(() => {

    api.get("/car?idCategory=" + filtro).then((response) => {
      setListCategorys(response.data)
      console.log(response)
    })
    .catch(() => {
      setListCategorys([])
    })
  }, [filtro]);
console.log (listCategorys)
const unique = listCategorys.filter(
  (obj, index) =>
  listCategorys.findIndex((item) => item.nameCar === obj.nameCar) === index
);
  return (
    <>
        <h2 id="motion-point">Resultados estão</h2>
    <div className="categoryCardSection">
      <div className="categoryCardContainer">

        {unique.map(({id, nameCar, urlImage, year, price}) => {
          return(
            
            <div className="categoryCardCard"  id="categoryCardCard">
            <div className="box" key={id}>
              
                <img src={url + urlImage} alt="" className='categoryCardImg'/>
                <h4 className='textCard1'>{nameCar}</h4>
                <h6 className='textCard2'>{year} | {price}</h6>
              
            </div>
      </div>
          )
        })}
      

      </div>
    </div>
    </>
  )
}

export default CategoriasCard