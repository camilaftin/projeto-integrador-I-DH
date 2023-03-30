import React, { useState, useEffect } from "react";
import "./searchCars.css";
import Select from "react-select";
import api from '../../services/api';
import moment from "moment";

import DateRangePicker from 'react-bootstrap-daterangepicker';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-daterangepicker/daterangepicker.css';

function SearchCars() {
  const [categories, setCategories] = useState([]);
  const [cities, setCities] = useState([]);

  // Desabilitar datas anteriores a hoje
  const disabledDate = (date) => {
    return moment(date).isBefore(moment().startOf('day')) && !moment(date).isSame(moment().startOf('day'));
  };

  useEffect(() => {
    api.get("/category")
      .then((response) => {
        let list = [];
        response.data.map((item) => {
          list.push({
            label: item.qualification,
            value: item.qualification
          })
        })
        setCategories(list)
        console.log("Deu certo - category")
      })
      .catch((error) => {
        console.log(error)
        console.log("Deu errado - category")
      })

    api.get("/city")
      .then((response) => {
        let list = [];
        response.data.map((item) => {
          list.push({
            label: item.nameCity,
            value: item.nameCity
          })
        })
        setCities(list)
        console.log("Deu certo - city")
      })
      .catch((error) => {
        console.log(error)
        console.log("Deu errado - city")
      })
  }, [])

  const handleSelectChange = (event) => {
    console.log(event);
  };

  const handleEvent = (event, picker) => {
    console.log(picker.startDate);
  };
  const handleCallback = (start, end, label) => {
    console.log(start, end, label);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
  };

  return (
    <div className="searchSection">
      <h1 className="sectionTitle">ALUGUE O CARRO DOS SEUS SONHOS</h1>

      <div className="searchContainer ">
        <div className="dropDown">
          <Select
            options={categories}
            onChange={handleSelectChange}
            className="select"
            placeholder="Categoria"
          />
        </div>

        <div className="dropDown">
          <Select
            options={cities}
            onChange={handleSelectChange}
            className="select"
            placeholder="Onde Vamos?"
          />
        </div>

        <div className=" drop">
          <DateRangePicker
            onEvent={handleEvent} onCallback={handleCallback}
          >
            <input className="form-control" />
          </DateRangePicker>
        </div>

        <button className="button button1" type='submit' onSubmit={handleSubmit}>BUSCAR</button>

      </div>
    </div>
  );
}

export default SearchCars;
